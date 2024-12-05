from django.db import models

# Create your models here.
class StockData(models.Model):
    from_symbol = models.TextField(null=True)
    to_symbol = models.TextField(null=True)
    data = models.TextField(null=True)