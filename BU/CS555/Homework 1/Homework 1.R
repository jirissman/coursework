library(readxl)
library(dplyr)
library(tidyr)

# Problem 1-3 -------------------------------------------------------------

# Read hospital data from Excel file
data <- read_excel("Homework 1/Homework 1 Data.xlsx", col_names = FALSE)

# Reformat excel data into a single variable
data <- stack(data)$values

# Plot histogram
hist(data, breaks = seq(0, max(data) + 1, by = 1),
     xlab = "Stay Duration (days)", ylab = "Count",
     main = "C. Difficile Patient Hospital Stays")

# Calculate summary statistics
summary(data)
sd(data)

# Problem 4 ---------------------------------------------------------------
population_mean <- 5
population_sd <- 3
sample_size <- 35
standard_error <- population_sd/sqrt(sample_size)

# Probability that duration is less than 10 days (P[X =< 9])
pnorm(10, mean = population_mean, sd = population_sd)

# Probability that sample mean is greater than 6 days (P[X > 6])
pnorm(6, mean = population_mean, sd = standard_error, lower.tail = FALSE)

