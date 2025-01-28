# CS555 Homework Assignment 6
# Load necessary libraries ------------------------------------------------

library(readxl)
library(dplyr)
library(tidyr)
library(pROC)

# Import and clean data ---------------------------------------------------

data = read_excel("Homework 6/Homework 6 Data.xlsx", col_names = TRUE)

# Problem 1 ---------------------------------------------------------------
# Create a new variable, called “temp_level” in which temp_level = 1 if body temperature >= 98.6 and temp_level=0 if body temperature < 98.6.
data$temp_level = if_else(data$temp >= 98.6, 1, 0)
summary(data)

# Problem 2 ---------------------------------------------------------------
# Summarize the data relating to body temperature level by sex.
count(data, sex, temp_level)

# Problem 3 ---------------------------------------------------------------
high_temp = data %>% filter(temp_level == 1) %>% count(sex)
measurements = data %>% count(sex)
prop.test(high_temp$n, measurements$n, correct = FALSE)

# Problem 4 ---------------------------------------------------------------
# Perform a logistic regression with sex as the only explanatory variable.
logistic = glm(temp_level ~ sex, family = binomial, data)
summary(logistic)

# Calculate the odds ratio for sex and the associated 95% confidence interval.
or = exp(logistic$coefficients["sex"])
lower95 = exp(logistic$coefficients["sex"] - qnorm(0.975) * summary(logistic)$coefficients["sex","Std. Error"])
upper95 = exp(logistic$coefficients["sex"] + qnorm(0.975) * summary(logistic)$coefficients["sex","Std. Error"])
paste0("95% confidence interval (",lower95,",",upper95,")")

# Calculate the c-statistic.
data$prob = predict(logistic, type=c("response"))
curve = roc(data$temp_level, data$prob)
print(curve)
plot(curve)

# Problem 5 ---------------------------------------------------------------
# Perform multiple logistic regression predicting body temperature level from sex and heart rate.
multiple = glm(temp_level ~ sex + `Heart rate`, family = binomial, data)
summary(multiple)

# Calculate the odds ratio for sex and heart rate (for a 10-beat increase).
or_sex = exp(multiple$coefficients["sex"]) 
or_hr = exp(multiple$coefficients[3] * 10)

# Calculate the c-statistic.
data$prob = predict(multiple, type=c("response"))
curve = roc(data$temp_level, data$prob)
print(curve)
plot(curve)