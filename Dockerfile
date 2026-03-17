# Use an official lightweight web server image
FROM nginx:alpine

# (Optional) Copy a custom index.html to the web server
# COPY index.html /usr/share/nginx/html/

# Expose port 90
EXPOSE 90
