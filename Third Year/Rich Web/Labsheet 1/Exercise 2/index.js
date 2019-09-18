// Country Array
var countryArray = new Array("Ireland", "USA", "England");

// cityArray Array
var cityArray = new Array();
cityArray[0] = "";
cityArray[1] = "Dublin,Meath,Louth,Galway,Kerry";
cityArray[2] = "Alaska,California,New York,Texas";
cityArray[3] = "London,Liverpool,Manchester,Newcastle";

//Function to populate cities in menu
function populateCities(countryElementId, cityElementId) {
    //variable to keep track of selected country
    var selectedCountryIndex = document.getElementById(countryElementId).selectedIndex;
    //variable to keep track of the selected city
    var cityElement = document.getElementById(cityElementId);

    //variable to reset the menu when selecting different countries
    cityElement.length = 0;
    //default state for menu when country is selected
    cityElement.options[0] = new Option('Select City', '');
    cityElement.selectedIndex = 0;

    //variable to store the cities from the array, seperating them after each ','
    var tempCity = cityArray[selectedCountryIndex].split(",");

    //loop to populate menu
    for (var i = 0; i < tempCity.length; i++) {
        cityElement.options[cityElement.length] = new Option(tempCity[i], tempCity[i]);
    }//end for
}//end function

//Function to populate countries in menu
function populateCountries(countryElementId, cityElementId) {
    //variable to keep track of selected country
    var countryElement = document.getElementById(countryElementId);
    //variable to reset the menu when selecting different countries
    countryElement.length = 0;
    //default state for menu when country is selected
    countryElement.options[0] = new Option('Select Country', '-1');
    countryElement.selectedIndex = 0;
    
    //Loop to populate menu 
    for (var i = 0; i < countryArray.length; i++) {
        countryElement.options[countryElement.length] = new Option(countryArray[i], countryArray[i]);
    }//end for 

    //if cityElementId is true 
    if (cityElementId) {
    	//update the menu
        countryElement.onchange = function () {
            populateCities(countryElementId, cityElementId);
        };//end inner function
    }//end if
}//end function