# CS555 Homework Assignment 5
# Load necessary libraries ------------------------------------------------

library(readxl)
library(dplyr)
library(tidyr)
library(purrr)
library(ggplot2)
library(car)
library(emmeans)

# Import and clean data ---------------------------------------------------

data = read_excel("Homework 5/Homework 5 Data.xlsx", col_names = TRUE)
df = tibble(data) %>% group_by(group)

# Problem 1 ---------------------------------------------------------------
# Summarize the data relating to both test score and age by the student group (separately).
# Use appropriate numerical and/or graphical summaries.

# Generate summary statistics for each group
df %>% split(.$group) %>% map(summary)

# Generate a scatter plot for each student group separately
scatter = function(data) {
  gg <- ggplot(data, aes(x = age, y = iq)) +
    geom_point() +
    labs(
      title = paste0("Test scores of ",data$group,"s")
    ) +
    theme_bw()
  plot(gg)
  ggsave(paste0("Homework 5/",group_keys(data)[[1]],"_scatter.png"))
  
}
for (group in df %>% split(.$group)) {
  scatter(group)
}

# Generate a scatter plot for all student groups
gg <- ggplot(df, aes(x = age, y = iq, colour = group)) +
  geom_point() +
  labs(
    title = paste0("Test scores of students")
  ) +
  theme_bw()
plot(gg)
ggsave(paste0("Homework 5/combined_scatter.png"))


# Problem 2 ---------------------------------------------------------------

# Perform a one way ANOVA using the aov or Anova function in R to assess test scores by student group.
# Use a significance level of α=0.05.
anova_model = aov(iq ~ group, df)
summary(anova_model)

# Calculate the critical F-score.
qf(0.95,2,42)

# Perform the appropriate pairwise comparisons using Tukey’s procedure to adjust for multiple comparisons.
TukeyHSD(anova_model)

# Problem 3 ---------------------------------------------------------------

# Create an appropriate number of dummy variables for student group.
# Set chemistry students as the reference group. 
df$chemistry = ifelse(df$group == "Chemistry student", 1, 0) # Reference group, not used in analysis.
df$physics = ifelse(df$group == "Physics student", 1, 0)
df$math = ifelse(df$group == "Math student", 1, 0)

# Re-run the one-way ANOVA using the lm function with the newly created dummy variables.
mlr_model <- lm(iq ~ physics + math, df)
summary(mlr_model)

# Problem 4 ---------------------------------------------------------------

# Re-do the one-way ANOVA adjusting for age (ANCOVA).  
ancova_model = lm(iq ~ group + age, df)
Anova(ancova_model, type = 3)

# Calcualte least square means.
emm_options(contrasts = c("contr.treatment", "contr.poly"))	
emmeans(ancova_model, specs = "group")