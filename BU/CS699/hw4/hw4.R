################################# Question 3 ###################################
library(e1071) # needed for Naive Bayes
library(C50) # needed for C5.0
library(caret) # needed for confusion matrix
library(rsample) # needed for split data
# read csv into df
bankruptcy <- read.csv('./hw4/Bankruptcy_reduced.csv')
# convert class to factor
bankruptcy$Class <- factor(bankruptcy$Class)
# split data into training and test
split <- initial_split(bankruptcy, prop = 0.66, strata = Class)
train <- training(split)
test <- testing(split)
# build a Naïve Bayes model from training data
bankruptcy.nb <- naiveBayes(Class~.,data=train)
# test on test data
bankruptcy.pred <- predict(bankruptcy.nb, newdata = test, type = "class")
# produce performance measures
performance.nb <- confusionMatrix(data=bankruptcy.pred, reference = test$Class)
performance.nb
# construct decision tree with C5.0
C5.tree <- C5.0(Class~., data = train)
# test on test data
bankruptcy.pred <- predict(C5.tree, newdata = test, type = "class")
# produce performance measures
performance.C5 <- confusionMatrix(data=bankruptcy.pred, reference = test$Class)
performance.C5
################################# Question 4 ###################################
# read csv into df
heart.df <- read.csv('./hw4/heart_disease_reduced.csv')
# convert class to factor
heart.df$class <- factor(heart.df$class)
# create logistic regression model
logit <- glm(class~resting_bp+cholesterol, data = heart.df, family = binomial)
# display model coefficients
coef(logit)
# create new patient and predict with model
new.patient <- data.frame("resting_bp"=137,"cholesterol"=250)
pred <- predict(logit, newdata = new.patient, type = "response")
# predict gives probability of success (i.e. class 2)
# subtract predict value from 1 to get the probability of failure (i.e. class 1)
classification <- data.frame("Probability" = c(1 - pred, pred))
classification
