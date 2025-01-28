# CS555 exam workspace

library(ggplot2)
library(dplyr)
library(car)
library(tidyr)

# Question 3
probability <- pnorm(1.6422, lower.tail = FALSE)
print(probability)

# Question 4
mean = 101
sd = 42
pop_mean = 96
n = 62
se = sd / sqrt(n)
z = (mean - pop_mean) / se
p_value = 2 * pnorm(-abs(z))

print("question 4")
print(paste("Test statistic:", z))
print(paste("p-value:", p_value))

# Question 5
mean = 138
sd = 12.95
probability <- pnorm(151, mean, sd) - pnorm(143, mean, sd)
print("question 5")
print(probability)


# Question 6
body_mass <- c(56, 49, 31, 28, 43, 35, 23, 33, 33, 42)
metabolic_rate <- c(1691, 1471, 1173, 965, 1162, 1114, 946, 1112, 1158, 1266)

data <- data.frame(body_mass, metabolic_rate)

model <- lm(metabolic_rate ~ body_mass, data = data)
print("question 6")
print(summary(model))

# Question 13
ss_total <- 900
ss_between <- 300
ss_within <- ss_total - ss_between

df_between <- 4 - 1  # Number of groups - 1
df_within <- 80 - 4  # Total number of observations - Number of groups

ms_between <- ss_between / df_between
ms_within <- ss_within / df_within

f_statistic <- ms_between / ms_within

print("question 13")
print(paste("F-statistic:", f_statistic))

# Question 14
print("question 14")
f_critical <- qf(0.95, 3, 15)
print(paste("Critical F-value:", f_critical))

# Question 16
p_value <- 0.0645 
adjusted_p_value <- p_value * 6

print("question 16")
print(paste("Bonferroni adjusted p-value:", adjusted_p_value))
