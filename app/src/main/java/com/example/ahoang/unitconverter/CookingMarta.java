package com.example.ahoang.unitconverter;

import android.app.Activity;
import java.util.Scanner;
import android.os.Bundle;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;


public class CookingMarta extends Activity {

    public static Scanner in = new Scanner(System.in);

    private Spinner input_unit;
    private Spinner output_unit;
    private Button convertbutton;
    private EditText input_value;
    private String string_input_value;
    private double double_input_value;
    private String [] input_unit_options;
    private String [] output_unit_options;


    public static double toMl (double input, int unitinput) {
        double mliter = 0;
        //1 = ounces // 2 = tbsp // 3 = cups // 4 = pint // 5 = quart // 6 = gallon // 7 = liters
        if (unitinput==1) {
            mliter = 30*input;
        } else if (unitinput==2) {
            mliter = 15*input;
        } else if (unitinput==3) {
            mliter = 250*input;
        } else if (unitinput==4) {
            mliter = 500*input;
        } else if (unitinput==5) {
            mliter = 1000 * input;
        } else if (unitinput ==6) {
            mliter = 4000 * input;
        } else if (unitinput == 7){
            mliter = 1000 * input;
        }

        return mliter;
    }

    public static double convertLiquid() {
        int unitinput, finalunit;
        double inputvalue, inputtoml, outputvalue;

        //get initial unit
        do {
            System.out.println("Initial liquid unit: ounces (1), tablespoon (2), cup (3), pint (4), quart (5), gallon (6), liters (7), or milliliters (8)");
            unitinput = in.nextInt();
            if (unitinput < 1 || unitinput > 8) {
                System.out.println("Invalid input. Try again.");
            }
        } while (unitinput < 1 || unitinput > 8);

        //convert to ml
        System.out.println("Initial liquid value: ");
        inputvalue = in.nextDouble();
        inputtoml = toMl(inputvalue, unitinput);

        //get final unit
        do {
            System.out.println("Choose final unit: ounces (1), tablespoon (2), cup (3), pint (4), quart (5), gallon (6), liters (7), or milliliters (8)");
            finalunit = in.nextInt();
            if (finalunit < 1 || finalunit > 8)
                System.out.println("Invalid unit. Try again.");
        } while (finalunit < 1 || finalunit > 8);

        //convert ml to other unit
        if (finalunit==1) {
            outputvalue = inputtoml/30;
        } else if (finalunit==2) {
            outputvalue = inputtoml/15;
        } else if ( finalunit==3) {
            outputvalue = inputtoml/250;
        } else if (finalunit==4) {
            outputvalue = inputtoml/500;
        } else if (finalunit == 5){
            outputvalue = inputtoml/1000;
        } else if (finalunit == 6) {
            outputvalue = inputtoml/4000;
        } else if (finalunit ==7 ) {
            outputvalue = inputtoml/1000;
        } else {
            outputvalue = inputvalue;
        }
        System.out.println("Final value is " + outputvalue);
        return outputvalue;
    }

    public static double togram (double input, int unitinput) {
        double gram = 0;
        //ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), kilogram (6), gram (7)
        if (unitinput==1) {
            gram = 28.6*input;
        } else if (unitinput==2) {
            gram = 14.3*input;
        } else if (unitinput==3) {
            gram = 4.766666666666*input;
        } else if (unitinput==4) {
            gram = 226.8*input;
        } else if (unitinput==5) {
            gram = 453.6 * input;
        } else if (unitinput ==6) {
            gram = 100 * input;
        }

        return gram;
    }

    public static double convertDry() {
        int unitinput, finalunit;
        double inputvalue, inputtogram, outputvalue;

        //get initial unit
        do {
            System.out.println("Initial mass unit: ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), kilogram (6), gram (7)");
            unitinput = in.nextInt();
            if (unitinput < 1 || unitinput > 7) {
                System.out.println("Invalid input. Try again.");
            }
        } while (unitinput < 1 || unitinput > 7);

        //convert to gram
        System.out.println("Initial mass value: ");
        inputvalue = in.nextDouble();
        inputtogram = togram(inputvalue, unitinput);

        //get final unit
        do {
            System.out.println("Choose final unit: ounces (1), tablespoon (2), teaspoon (3), cup (4), pound (5), kilogram (6), gram (7)");
            finalunit = in.nextInt();
            if (finalunit < 1 || finalunit > 8)
                System.out.println("Invalid unit. Try again.");
        } while (finalunit < 1 || finalunit > 8);

        //convert gram to other unit
        if (finalunit==1) {
            outputvalue = inputtogram/28.6;
        } else if (finalunit==2) {
            outputvalue = inputtogram/14.3;
        } else if ( finalunit==3) {
            outputvalue = inputtogram/4.7666666666;
        } else if (finalunit==4) {
            outputvalue = inputtogram/226.8;
        } else if (finalunit == 5){
            outputvalue = inputtogram/453.6;
        } else if (finalunit == 6) {
            outputvalue = inputtogram/100;
        } else {
            outputvalue = inputvalue;
        }
        System.out.println("Final value is " + outputvalue);
        return outputvalue;
    }


    public static double convertOven() {
        int unitinput;
        double inputvalue;
        double outputvalue=0;

        //get initial unit
        do {
            System.out.println("Initial temperature unit: celsius (1) or fahrenheit ");
            unitinput = in.nextInt();
            if (unitinput < 1 || unitinput > 2) {
                System.out.println("Invalid input. Try again.");
            }
        } while (unitinput < 1 || unitinput > 2);

        System.out.println("Initial temperature value: ");
        inputvalue = in.nextDouble();

        //Conversor
        if (unitinput ==1){
            outputvalue =  inputvalue  * 9/5 + 32;
        }
        else if (unitinput ==2) {
            outputvalue = ( inputvalue - 32) / (9/5);
        }
        System.out.println("Final value is " + outputvalue);
        return outputvalue;
    }

    public static void main(String[] args) {
        System.out.println("Please select one");
        System.out.println("Liquid Measurements (1), Dry Measurements (2), Oven Temperature (3)");
        int convtype = in.nextInt();
        do {
            if (convtype == 1) {
                convertLiquid();
            } else if (convtype == 2) {
                convertDry();
            } else if (convtype == 3) {
                convertOven();
            } else {
                System.out.println("Invalid input. Try again.");
            }
        } while (convtype < 1 || convtype > 3);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cookingmarta);
        input_value=(EditText) findViewById(R.id.editText);
        string_input_value = input_value.getText().toString();
        //double_input_value = Double.valueOf(string_input_value).doubleValue(); THIS IS NOT WORKING
        //It should throw an error here to verify input!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

        //Drop down menu
        input_unit = (Spinner) findViewById(R.id.planets_spinner);
        input_unit_options = getResources().getStringArray(R.array.input_unit_options1);
        ArrayAdapter<String> dataAdapter_in = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, input_unit_options);
        input_unit.setAdapter(dataAdapter_in);
        dataAdapter_in.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        output_unit = (Spinner) findViewById(R.id.spinner);
        output_unit_options = getResources().getStringArray(R.array.output_unit_options1);
        ArrayAdapter<String> dataAdapter_out = new ArrayAdapter<String> (this, android.R.layout.simple_spinner_item, output_unit_options);
        output_unit.setAdapter(dataAdapter_out);
        dataAdapter_out.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // NEED ERROR CHECK

        convertbutton = (Button) findViewById(R.id.button);

        convertbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                // Connect to converter functions





            }
        });




    }

}