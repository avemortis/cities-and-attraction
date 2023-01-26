# cities-and-attraction
 # Setup:
  1. Open https://github.com/avemortis/cities-and-attraction/blob/master/src/main/resources/application.properties file and change configuration based on your PostgreSQL settings
  2. Build and run project
  3. Open localhost in your browser
 # Methods:
  # GET:
   1. Get all cities: http://localhost:8080/cities
   2. Get all attractions: http://localhost:8080/attractions
   3. Get all cathedrals sorted: http://localhost:8080/attractions?isSorted=1&attractionType=CATHEDRAL
   4. Get all attractions for Moscow: http://localhost:8080/attractions/Moscow
  # POST:
   1. Post new city: http://localhost:8080/city?name=Tomsk&country=Russia&population=600000&haveMetro=0
   2. Post new attraction: http://localhost:8080/attraction?city=Moscow&name=Some Cool place&desc=Very Cool Place&bdate=2022-12-23&type=CATHEDRAL
  # PUT:
   1. Edit city: http://localhost:8080/city/2?population=647000&haveMetro=1
   2. Edit attraction: http://localhost:8080/attraction/3?desc=This plase is not cool anymore
  # DELETE:
   1. Delete attraction: http://localhost:8080/attraction/2
