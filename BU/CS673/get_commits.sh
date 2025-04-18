#!/bin/bash

# Set date to 2 weeks ago
TWO_WEEKS_AGO=$(date -v-14d +"%Y-%m-%d" 2>/dev/null || date -d "14 days ago" +"%Y-%m-%d")

# Fetch all branches to ensure we have latest data
git fetch --all

# Get all branch names
BRANCHES=$(git branch -a | sed 's/^\*\?\s*//')

# Create a temp file for results
TEMP_FILE=$(mktemp)

echo "Commits from all branches since $TWO_WEEKS_AGO:" > "$TEMP_FILE"
echo "================================================" >> "$TEMP_FILE"

# Loop through each branch
for branch in $BRANCHES; do
  # Clean up branch names (remove remote/ prefix if present)
  clean_branch=$(echo "$branch" | sed 's#remotes/origin/##')
  
  # Skip if this is just a HEAD pointer or other special ref
  if [[ "$clean_branch" == "HEAD"* || "$clean_branch" == *"->"* ]]; then
    continue
  fi

  echo "" >> "$TEMP_FILE"
  echo "Branch: $clean_branch" >> "$TEMP_FILE"
  echo "------------------------" >> "$TEMP_FILE"
  
  # Get commit logs for this branch since the date
  git log --since="$TWO_WEEKS_AGO" --date=iso --pretty=format:"%h - %an, %ad : %s%n%b%n" "$clean_branch" 2>/dev/null >> "$TEMP_FILE"
done

# Output to a file in your current directory
OUTPUT_FILE="git_commits_$(date +"%Y%m%d").txt"
mv "$TEMP_FILE" "$OUTPUT_FILE"

echo "Commit history saved to $OUTPUT_FILE"