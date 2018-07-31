package com.davissylvester.guidedtourappjava.DomainClasses;

import java.util.ArrayList;
import java.util.jar.Attributes;


public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    public ArrayList<AttractionData> getData() {
        return Data;
    }

    ArrayList<AttractionData> Data;

    private DataService() {

        this.Data = new ArrayList<>();

        loadData();


    }

    private void loadData() {

        Data.add(new AttractionData(ApplicationConstants.WILDLIFE_RANCH,
                "26515 Natural Bridge Caverns Rd, San Antonio, TX 78266",
                "Natural Bridge Wildlife Ranch is a 400-acre safari park on the northern outskirts of San Antonio, near New Braunfels, Texas",
                "$22.00",
                "witte_museum"));

        Data.add(new AttractionData(ApplicationConstants.RIVERWALK,
                "849 E. Commerce Street, San Antonio, TX 78205",
                "The San Antonio River Walk is a city park and network of walkways along the banks of the San Antonio River, " +
                      "one story beneath the streets of San Antonio, Texas",
                "FREE",
                "riverwalk"));

        Data.add(new AttractionData(ApplicationConstants.ALAMO,
                "300 Alamo Plaza, San Antonio, TX 78205",
                "The Alamo Mission in San Antonio is commonly called The Alamo and was originally known as Misión San Antonio de Valero",
                "FREE",
                "alamo"));

        Data.add(new AttractionData(ApplicationConstants.RIPLEY,
                "301 Alamo Plaza, San Antonio, TX 78205",
                "Museum with kitschy oddities on display, including shrunken human heads & rare animal skeletons.",
                "$21.99",
                "ripleys_museum"));
    }
}
