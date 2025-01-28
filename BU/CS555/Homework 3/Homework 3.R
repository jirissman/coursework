# CS555 Homework Assignment 3
# Load necessary libraries ------------------------------------------------
library(readxl)
library(dplyr)
library(tidyr)
library(ggplot2)

# Import and clean data ---------------------------------------------------
# Read experiment data from Excel file
data <- read_excel("Homework 3/Homework 3 Data.xlsx", col_names = TRUE)
names(data) <- c("Meals","Mercury")

# Problem 1 ---------------------------------------------------------------
# Generate a scatterplot
gg <- ggplot(data, aes(x = Meals, y = Mercury)) +
  geom_point(alpha = 0.5) +
  labs(
    x = "Number of Meals with Fish per Week",
    y = "Total Mercury (mg/g)",
    title = "Mercury Content of Fishermen Head Hair "
  ) +
  theme_bw()
plot(gg)
ggsave("Homework 3/scatter.png")


# Problem 2 ---------------------------------------------------------------

# Calculate the correlation coefficient. 
cor(data)

# Problem 3 ---------------------------------------------------------------

# Find the equation of the least squares regression equation.
model <- lm(Mercury ~ Meals, data)
coefficients <- coef(model)
coefficients

# Add the regression line to the scatterplot.
gg <- gg + geom_abline(
  intercept = coefficients[1],
  slope = coefficients[2]
  )
plot(gg)
ggsave("Homework 3/regression.png")


# Problem 4 ---------------------------------------------------------------

# Calculate the estimates for B0 and B1  
summary(model)

# Problem 5 ---------------------------------------------------------------

# Calculate the ANOVA table.
anova(model)

# Calculate the 90% confidence interval for B1
confint(model, "Meals", level = 0.9)