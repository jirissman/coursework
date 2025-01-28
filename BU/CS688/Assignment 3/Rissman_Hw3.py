import requests
import pandas as pd
import re
from bs4 import BeautifulSoup
from afinn import Afinn
from nrclex import NRCLex

# Q1 - On “https://www.commonsensemedia.org/book-reviews” search for “kids-books-about-911”.

url = "https://www.commonsensemedia.org/search/category/book/sort/score-desc/kids-books-about-911"

# Q2 - 2-	Get the URL for the first page of results and utilize Beautiful Soup to get all of reviews from these pages. 

def beautiful_soupify(url):
  """Fetches the HTML content of a given URL and parses it using BeautifulSoup.

  Args:
    url (str): The URL of the web page to fetch.

  Returns:
    BeautifulSoup object or None: The parsed BeautifulSoup object if the request is successful, or None if the request fails.
  """

  # Send a GET request to the specified URL
  response = requests.get(url)

  # Check if the request was successful (status code 200)
  if response.status_code == 200:
    # Parse the HTML content using BeautifulSoup
    soup = BeautifulSoup(response.content, 'html.parser')
    return soup
  else:
    print("Connection request failed. Status code:", response.status_code)
    return None  # Return None to indicate a failed request    

def extract_books(url):
    """Extracts books from a given Common Sense Media search URL.

    Args:
        url (str): The URL of the page to scrape.

    Returns:
        ResultSet: A Beautiful Souop ResultSet with URLs for each book found in the search.
    """

    soup = beautiful_soupify(url)
    
    if soup:
      # Find all links with href containing "/book-reviews/" and no class attribute
      # This retrieves a link to each book on the webpage only once
      links = soup.find_all('a',attrs={'href': re.compile("/book-reviews/"), "class": ""})

    return links

def extract_reviews(url):
    """Extracts reviews from a given Common Sense Media book review URL.

    Args:
        url (str): The URL of the page to scrape.

    Returns:
        list: A data frame with book name and reviews.
    """

    reviews = []

    # Extract parent reviews
    adult_url = "https://www.commonsensemedia.org" + url + "/user-reviews/adult"
    adult_soup = beautiful_soupify(adult_url)
    title = adult_soup.find('h1').text
    result = adult_soup.find_all("div", class_="reveal__content")
    for res in result:
      reviews.append({"book title": title, "review": res.text})

    # Extract kid reviews
    child_url = "https://www.commonsensemedia.org" + url + "/user-reviews/child"
    child_soup = beautiful_soupify(child_url)
    result = child_soup.find_all("div", class_="reveal__content")
    for res in result:
      reviews.append({"book title": title, "review": res.text})

    return pd.DataFrame(reviews)

def get_all_reviews(url):
  """Gets reviews for all books from a given Common Sense Media search URL.

  Args:
    url (str): The URL of the search page.

  Returns:
    pd.DataFrame: A DataFrame containing book titles and reviews.
  """

  # Initialize an empty DataFrame to store reviews
  reviews = pd.DataFrame({"book title": [], "review": []})

  # Extract book links from the search URL
  for link in extract_books(url):

    # Extract reviews for the current book
    book_reviews = extract_reviews(link['href'])

    # Concatenate the book's reviews with the existing DataFrame
    reviews = pd.concat([reviews, book_reviews])

  return reviews


# # Q3 - Use afinn method for sentiment analysis.
# The output should be a data frame with each review, the afn.score and label you create based on the score (0: neutral, <0 negative and >0 positive). 

def afinn_sentiment_analysis(review):
  """Performs sentiment analysis on a given review using the AFINN lexicon.

  Args:
    review (dict): A dictionary containing the 'review' text.

  Returns:
    tuple: A tuple containing the sentiment score and label.
  """

  # Create an AFINN analyzer
  afinn = Afinn()

  # Extract the review text
  text = review['review']

  # Calculate the sentiment score
  sentiment_score = afinn.score(text)

  # Assign a sentiment label based on the score
  if sentiment_score < 0:
    label = 'negative'
  elif sentiment_score == 0:
    label = 'neutral'
  else:
    label = 'positive'

  return sentiment_score, label

# Get reviews for all books from the search URL
afinn_reviews = get_all_reviews(url)

# Perform sentiment analysis using AFINN for each review
afinn_reviews[['afinn_score', 'label']] = afinn_reviews.apply(
    afinn_sentiment_analysis, axis=1, result_type="expand"
)

# Print the DataFrame with sentiment scores and labels
print(afinn_reviews)

# # Q4 - Add the name of the restaurant to the data frame in question 3.
"""
It was much easier to add the name of the book to the dataframe when extracting the reviews, so this has already been done in the extract_reviews funciton.
"""

# # Q5 -	Use NRCLex method for sentiment analysis.
# Pass each review to NRCLex and get top_emotions for that review, store all reviews and their top emotions in a text file.

def NRCLex_sentiment_analysis(review):
  """Performs sentiment analysis on a given review using the NRC Lexicon.

  Args:
    review (dict): A dictionary containing the 'review' text.

  Returns:
    dict: A dictionary containing the top emotions and their associated scores.
  """

  text = review['review']
  text_object = NRCLex(text)
  return text_object.top_emotions

# Get reviews for all books from the search URL
NRCLex_reviews = get_all_reviews(url)

# Perform sentiment analysis using NRC Lexicon for each review
NRCLex_reviews['emotions'] = NRCLex_reviews.apply(
    NRCLex_sentiment_analysis, axis=1
)

# Drop the 'book title' column as it's not needed for output
NRCLex_reviews = NRCLex_reviews.drop('book title', axis=1)

# Specify path for export
path = r'/Users/jirissman/Documents/coursework/BU/CS688/Assignment 3/NRCLex_emotions.txt'

# Export DataFrame to text file
with open(path, 'a') as f:
  f.write(NRCLex_reviews.to_string(index=False, header=False))