# CS555 Homework Assignment 2
# Load necessary libraries ------------------------------------------------
library(readxl)
library(dplyr)
library(tidyr)
library(ggplot2)

# Import and clean data ---------------------------------------------------
# Read experiment data from Excel file
data <- read_excel("Homework 2/Homework 2 Data.xlsx", col_names = TRUE)
df <- data_frame(data) %>% 
  rename(participants = 'Calorie Intake for participants',
         non_participants = 'Calorie intake for non-participants')

# Problem 1 ---------------------------------------------------------------
# Calculate summary statistics of data for each group
summary(df)
sd(df$participants)
sd(df$non_participants, na.rm = TRUE)

# Create histograms for each group to visualize data
ggplot(df, aes(x = participants)) +
  geom_histogram(binwidth = 50, fill = "skyblue", color = "black") +
  labs(title = "Histogram of Calorie Intake for Participants",
       x = "Calorie Intake",
       y = "Frequency") +
  theme_minimal()

ggplot(df, aes(x = non_participants)) +
  geom_histogram(binwidth = 50, fill = "orange", color = "black") +
  labs(title = "Histogram of Calorie Intake for Non-Participants",
       x = "Calorie Intake",
       y = "Frequency") +
  theme_minimal()

# Pivot the data to create a box plot
df_pivot <- df %>%
  pivot_longer(cols = c(participants, non_participants),
               names_to = "group",
               values_to = "value",
               values_drop_na = FALSE)
# Create box plot to visualize data from each group
ggplot(df_pivot, aes(x = group, y = value)) +
  geom_boxplot(fill = "skyblue", outlier.color = "blue") +
  labs(title = "Calorie Intake of Participants vs. Non-Participants",
       x = NULL,
       y = "Calorie Intake") +
  coord_flip() +
  scale_x_discrete(labels = c('Non-Participants','Participants')) +
  stat_summary(fun = "mean", geom = "point", size = 3, color = "blue") +
  theme_minimal()

# Problem 2 ---------------------------------------------------------------

# Calculate t.test that participants have mean calorie consumption different than 425.
t.test(df$participants, mu = 425, alternative = "two.sided", conf.level = 0.95)

# Problem 3 ---------------------------------------------------------------

# Calculate 90% confidence interval using t.test method
t.test(df$participants, conf.level = 0.9)$conf.int

# Problem 4 ---------------------------------------------------------------

# Calculate two-sample t.test that participants have difference from non-participants.
t.test(x = df$participants, y = df$non_participants, alternative = "two.sided", conf.level = 0.95)

# Problem 5 ---------------------------------------------------------------

# Create quantile-quantile plot for both groups to assess normality
qqnorm(df$participants, main = "Normal Q-Q Plot for Participants")
qqline(df$participants)
qqnorm(df$non_participants, main = "Normal Q-Q Plot for Non-Participants")
qqline(df$non_participants)
