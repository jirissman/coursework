# CS555 Homework Assignment 4
# Load necessary libraries ------------------------------------------------

library(readxl)
library(dplyr)
library(tidyr)
library(ggplot2)
library(easystats)

# Import and clean data ---------------------------------------------------

data <- read_excel("Homework 4/Homework 4 Data.xlsx", col_names = TRUE)

# Problem 1 ---------------------------------------------------------------

# Generate a scatter plot
gg <- ggplot(data, aes(x = `Education Level (years)`, y = `Prestige Score`)) +
  geom_point(alpha = 0.5) +
  labs(
    title = "Professional Prestige for Canadians with Varying Levels of Education"
  ) +
  theme_bw()
plot(gg)
ggsave("Homework 4/scatter.png")

# Calculate the correlation coefficient. 
cor(data$`Education Level (years)`,data$`Prestige Score`)


# Problem 2 ---------------------------------------------------------------

# Perform a simple linear regression.
model <- lm(`Prestige Score` ~ `Education Level (years)`, data)
coef(model)

# Generate a residual plot.
residuals <- model$residuals
fitted_values <- model$fitted.values
residual_data <- data.frame(fitted_values, residuals)
gg <- ggplot(residual_data, aes(x = fitted_values, y = residuals)) +
  geom_point() +
  geom_hline(
    yintercept = 0,
    linetype = "dashed",
    color = "black"
    ) +
  labs(
    x = "Prestige Score",
    y = "Residuals",
    title = "Residual Plot"
    ) +
  theme_bw()
plot(gg)
ggsave("Homework 4/residual_slr.png")

# Identify outliers and influence points.
outliers_list <- check_outliers(model)
outliers_list
plot(outliers_list)

# Problem 3 ---------------------------------------------------------------

# Calculate the least squares regression equation.
model <- lm(`Prestige Score` ~ `Education Level (years)` + `Income ($)` + `Percent of Workforce that are Women`, data)
summary(model)

# Calculate the critical F-score.
qf(0.95,3,98)

# Calculate F-score of model.
totalss <- sum((data$`Prestige Score` - mean(data$`Prestige Score`))^2)
regss <- sum((fitted(model) - mean(data$`Prestige Score`))^2)
resiss <- sum((data$`Prestige Score` - fitted(model))^2)
fstatistic <- (regss/3)/(resiss/98)

# Problem 4 ---------------------------------------------------------------

# Summarize the information about the contribution of each variable.
summary(model)

# Calculate the critical t-value.
qt(0.975,98)

# Calculate the 95% confidence intervals.
confint(model, level = 0.95)

# Problem 5 ---------------------------------------------------------------

# Generate a residual plot.
residuals <- model$residuals
fitted_values <- model$fitted.values
residual_data <- data.frame(fitted_values, residuals)
gg <- ggplot(residual_data, aes(x = fitted_values, y = residuals)) +
  geom_point() +
  geom_hline(
    yintercept = 0,
    linetype = "dashed",
    color = "black"
  ) +
  labs(
    x = "Prestige Score",
    y = "Residuals",
    title = "Residual Plot"
  ) +
  theme_bw()
plot(gg)
ggsave("Homework 4/residual_mlr.png")

# Identify outliers and influence points.
outliers_list <- check_outliers(model)
outliers_list
plot(outliers_list)
