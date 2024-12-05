from django.shortcuts import render
from django.http import HttpResponse
from django.views.decorators.csrf import csrf_exempt
from .models import StockData

import requests
import json


APIKEY = "UHJBTQCAN7SDZW3O" 
APIKEY2 = "NQGD5POOOSM90B7D"
#replace "my_alphav_api_key" with your actual Alpha Vantage API key obtained from https://www.alphavantage.co/support/#api-key


DATABASE_ACCESS = True 
#if False, the app will always query the Alpha Vantage APIs regardless of whether the stock data for a given ticker is already in the local database


#view function for rendering home.html
def home(request):
    return render(request, "home.html", {})

@csrf_exempt
def get_forex_data(request):
    if request.headers.get('x-requested-with') == 'XMLHttpRequest':
        #get ticker from the AJAX POST request
        from_symbol = request.POST.get("from_symbol", "null")
        to_symbol = request.POST.get("to_symbol", "null")
        from_symbol = from_symbol.upper()
        to_symbol = to_symbol.upper()

        # if DATABASE_ACCESS == True:
        #     #checking if the database already has data stored for this ticker before querying the Alpha Vantage API
        #     if StockData.objects.filter(symbol=ticker).exists(): 
        #         #We have the data in our database! Get the data from the database directly and send it back to the frontend AJAX call
        #         entry = StockData.objects.filter(symbol=ticker)[0]
        #         return HttpResponse(entry.data, content_type="application/json")

        #obtain forex data from Alpha Vantage APIs
        #get forex daily close data
        forex_prices_series = requests.get(f"https://www.alphavantage.co/query?function=FX_DAILY&from_symbol={from_symbol}&to_symbol={to_symbol}&apikey={APIKEY}").json()
        forex_prices_realtime = requests.get(f"https://www.alphavantage.co/query?function=CURRENCY_EXCHANGE_RATE&from_currency={from_symbol}&to_currency={to_symbol}&apikey={APIKEY2}").json()

        #package up the data in an output dictionary 
        output_dictionary = {}
        output_dictionary["forex_prices"] = forex_prices_series
        output_dictionary["forex_realtime"] = forex_prices_realtime

        #save the dictionary to database
        temp = StockData(from_symbol=from_symbol, to_symbol = to_symbol, data=json.dumps(output_dictionary))
        temp.save()

        #return the data back to the frontend AJAX call 
        return HttpResponse(json.dumps(output_dictionary), content_type="application/json")

    else:
        message = "Not Ajax"
        return HttpResponse(message)