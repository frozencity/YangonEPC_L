package com.thak.ygnepc;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.AdapterView.OnItemSelectedListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment{

        public PlaceholderFragment() {
        }

        Spinner spinner;
        Button btn_one;
        Button btn_two;
        Button btn_three;
        TextView tv;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_selection, container, false);

            btn_one = (Button) rootView.findViewById(R.id.btn_num_one);
            btn_two = (Button) rootView.findViewById(R.id.btn_num_tsu);
            btn_three = (Button) rootView.findViewById(R.id.btn_num_sree);

            tv = (TextView) rootView.findViewById(R.id.info_text);

            spinner = (Spinner) rootView.findViewById(R.id.spinner);

            // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                    R.array.Townships, android.R.layout.simple_spinner_item);
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Apply the adapter to the spinner
            spinner.setAdapter(adapter);
            setOnItemSelect();

            btn_one.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+btn_one.getText().toString()));
                    startActivity(intent);
                }
            });

            btn_two.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+btn_two.getText().toString()));
                    startActivity(intent);
                }
            });

            btn_three.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+btn_three.getText().toString()));
                    startActivity(intent);
                }
            });


            return rootView;
        }


        public void setOnItemSelect(){
            spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

                public void onItemSelected(AdapterView<?> parent, View view,
                                           int pos, long id) {
                    // An item was selected. You can retrieve the selected item using
                    // parent.getItemAtPosition(pos)
                    tv.setText(parent.getItemAtPosition(pos).toString());

                    //Text from Buttons will change according to the item selected.
                    switch (pos){
                        case 0:
                            btn_one.setText(R.string.m1_Ahlon_Sanchaung1);
                            btn_two.setText(R.string.m1_Ahlon_Sanchaung2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 1:
                            btn_one.setText(R.string.m2_Bahan_Dagon1);
                            btn_two.setText(R.string.m2_Bahan_Dagon2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 2:
                            btn_one.setText(R.string.m3_Botahtaung);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 3:
                            btn_one.setText(R.string.m4_Dagon_Myothit_North1);
                            btn_two.setText(R.string.m4_Dagon_Myothit_North2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 4:
                            btn_one.setText(R.string.m5_Dagon_Myothit_South1);
                            btn_two.setText(R.string.m5_Dagon_Myothit_South2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 5:
                            btn_one.setText(R.string.m6_Dala);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 6:
                            btn_one.setText(R.string.m7_Hlaing);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 7:
                            btn_one.setText(R.string.m8_Hlaing_Thayar1);
                            btn_two.setText(R.string.m8_Hlaing_Thayar2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setText(R.string.m8_Hlaing_Thayar3);
                            btn_three.setVisibility(View.VISIBLE);
                            break;
                        case 8:
                            btn_one.setText(R.string.m9_Hlegu);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 9:
                            btn_one.setText(R.string.m10_Hmawbi);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 10:
                            btn_one.setText(R.string.m11_Htauntkyant);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 11:
                            btn_one.setText(R.string.m12_Insein_Mingalardon1);
                            btn_two.setText(R.string.m12_Insein_Mingalardon2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 12:
                            btn_one.setText(R.string.m13_Kamayut_Kyeemyindaing);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 13:
                            btn_one.setText(R.string.m14_Kungyankone);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 14:
                            btn_one.setText(R.string.m15_Kyauktada_Pabedan);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 15:
                            btn_one.setText(R.string.m16_Kyauktan1);
                            btn_two.setText(R.string.m16_Kyauktan2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 16:
                            btn_one.setText(R.string.m17_Lanmadaw_Latha1);
                            btn_two.setText(R.string.m17_Lanmadaw_Latha2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 17:
                            btn_one.setText(R.string.m18_Lat_khok_kone);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 18:
                            btn_one.setText(R.string.m19_Mayangone1);
                            btn_two.setText(R.string.m19_Mayangone2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 19:
                            btn_one.setText(R.string.m20_Mingala_Taung_Nyunt);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 20:
                            btn_one.setText(R.string.m21_North_Okkalapa1);
                            btn_two.setText(R.string.m21_North_Okkalapa2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 21:
                            btn_one.setText(R.string.m22_Pazundaung);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 22:
                            btn_one.setText(R.string.m23_Shwe_pauk_kan);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 23:
                            btn_one.setText(R.string.m24_Shwe_Pyi_Thar);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 24:
                            btn_one.setText(R.string.m25_South_Okkalapa1);
                            btn_two.setText(R.string.m25_South_Okkalapa2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 25:
                            btn_one.setText(R.string.m26_Tamwe1);
                            btn_two.setText(R.string.m26_Tamwe2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 26:
                            btn_one.setText(R.string.m27_Thaketa_Dawbon1);
                            btn_two.setText(R.string.m27_Thaketa_Dawbon2);
                            btn_two.setVisibility(View.VISIBLE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 27:
                            btn_one.setText(R.string.m28_Thingan_Kyun);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                        case 28:
                            btn_one.setText(R.string.m29_Yankin);
                            btn_two.setVisibility(View.GONE);
                            btn_three.setVisibility(View.GONE);
                            break;
                    }
                }

                public void onNothingSelected(AdapterView<?> parent) {
                    // Another interface callback
                    tv.setText("Not Selected");

                }
            });
        }

    }
}
