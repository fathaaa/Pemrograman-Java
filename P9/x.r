sample_data <- data.frame(fitur1 = c(4,3), fitur2 = c(3, 4.5))
ev <- eigen(sample_data)
values <- ev$values
values
vectors <- ev$vectors
vectors

results <- prcomp(sample_data, scale = TRUE)

#reverse the signs
results$rotation <- -1*results$rotation

#display principal components
results$rotation