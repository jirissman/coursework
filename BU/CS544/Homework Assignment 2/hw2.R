library(ggplot2)
hmean <- 69
hstdev <- 2.5
heights <- ggplot(data.frame(x = c(hmean-4*hstdev, hmean+4*hstdev)), aes(x = x)) +
  stat_function(fun = dnorm, args = list(hmean,hstdev)) +
  scale_x_continuous(name = "Inches",breaks = seq(hmean-4*hstdev, hmean+4*hstdev, by = hstdev)) +
  scale_y_continuous(name = "Frequency") +
  ggtitle("Heights of Adult American Men") +
  geom_vline(xintercept = (hmean-1*hstdev)) +
  geom_vline(xintercept = (hmean+1*hstdev)) +
  annotate("text", x=hmean-1*hstdev-.5, y=.15, label="-1\u03C3", angle=90) +
  annotate("text", x=hmean+1*hstdev-.5, y=.15, label="+1\u03C3", angle=90) +
  geom_vline(xintercept = (hmean-2*hstdev)) +
  geom_vline(xintercept = (hmean+2*hstdev)) +
  annotate("text", x=hmean-2*hstdev-.5, y=.15, label="-2\u03C3", angle=90) +
  annotate("text", x=hmean+2*hstdev-.5, y=.15, label="+2\u03C3", angle=90) +
  geom_vline(xintercept = (hmean-3*hstdev)) +
  geom_vline(xintercept = (hmean+3*hstdev)) +
  annotate("text", x=hmean-3*hstdev-.5, y=.15, label="-3\u03C3", angle=90) +
  annotate("text", x=hmean+3*hstdev-.5, y=.15, label="+3\u03C3", angle=90)

pmean <- 266
pstdev <- 6
pregnancies <- ggplot(data.frame(x = c(pmean-4*pstdev, pmean+4*pstdev)), aes(x = x)) +
  stat_function(fun = dnorm, args = list(pmean,pstdev)) +
  scale_x_continuous(name = "Days",breaks = seq(pmean-4*pstdev, pmean+4*pstdev, by = pstdev)) +
  scale_y_continuous(name = "Frequency") +
  ggtitle("Length of Human Pregnancies from Conception to Birth") +
  geom_vline(xintercept = (pmean-1*pstdev)) +
  geom_vline(xintercept = (pmean+1*pstdev)) +
  annotate("text", x=pmean-1.2*pstdev, y=.06, label="-1\u03C3", angle=90) +
  annotate("text", x=pmean+1.2*pstdev, y=.06, label="+1\u03C3", angle=90) +
  geom_vline(xintercept = (pmean-2*pstdev)) +
  geom_vline(xintercept = (pmean+2*pstdev)) +
  annotate("text", x=pmean-2.2*pstdev, y=.06, label="-2\u03C3", angle=90) +
  annotate("text", x=pmean+2.2*pstdev, y=.06, label="+2\u03C3", angle=90) +
  geom_vline(xintercept = (pmean-3*pstdev)) +
  geom_vline(xintercept = (pmean+3*pstdev)) +
  annotate("text", x=pmean-3.2*pstdev, y=.06, label="-3\u03C3", angle=90) +
  annotate("text", x=pmean+3.2*pstdev, y=.06, label="+3\u03C3", angle=90)

snmean <- 0
snstdev <- 1
standardnormal <- ggplot(data.frame(x = c(snmean-4*snstdev, snmean+4*snstdev)), aes(x = x)) +
  stat_function(fun = dnorm, args = list(snmean,snstdev)) +
  scale_x_continuous(name = "Z-score",breaks = seq(snmean-4*snstdev, snmean+4*snstdev, by = snstdev)) +
  scale_y_continuous(name = "Probability Density") +
  ggtitle("Standard Normal Distribution")
