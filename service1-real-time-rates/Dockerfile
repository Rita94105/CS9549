# Use an official Python runtime as a base image
FROM python:3.10-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the requirements file to the working directory
COPY requirements.txt /app/

# Install the required Python packages
RUN pip install --no-cache-dir -r requirements.txt

# Copy the entire Django project into the working directory
COPY . /app

# Set environment variables for Django
ENV PYTHONUNBUFFERED=1

# Create the staticfiles directory to avoid runtime issues
RUN mkdir /app/staticfiles

# Collect static files
RUN python manage.py collectstatic --no-input

# Expose the port that your Django server will run on
EXPOSE 8000

# Run the Gunicorn server to serve the Django application
CMD ["gunicorn", "--bind", "0.0.0.0:8000", "alphaVantage.wsgi:application"]
