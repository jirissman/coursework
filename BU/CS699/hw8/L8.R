library(dplyr)
library(tidyverse)
library(arulesSequences)

setwd('C:/Courses/C2024/699/Slides/L8')
df <- read.csv('L8_ex.csv')
df
colnames(df) = c("sequenceID", "eventID", "SIZE", "Items")
df
df[c(1,2)] <- data.frame(lapply(df[c(1,2)], as.factor))
df

# Convert to transaction data type
write.table(df, "temp.txt", sep=",", row.names = FALSE, col.names = FALSE, quote = FALSE)
L8_ex.tr <- read_baskets("temp.txt", sep = ",", info = c("sequenceID","eventID","SIZE"))
L8_ex.tr

frequent_sequences <- cspade(L8_ex.tr, parameter = list(support = 0.4), control = list(verbose = TRUE))
summary(frequent_sequences)
frequent_sequences.df <- as(frequent_sequences, "data.frame")
frequent_sequences.df

# Get temporal rules from frequent itemsets
rules <- as(ruleInduction(frequent_sequences, confidence = 0.3, control = list(verbose = TRUE)), "data.frame")
rules

##########################################################################################################

