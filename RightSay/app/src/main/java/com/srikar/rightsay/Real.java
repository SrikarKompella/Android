package com.srikar.rightsay;

import android.graphics.drawable.ColorDrawable;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

public class Real extends AppCompatActivity {
    EditText word;
    AutoCompleteTextView autoCompleteTextView;
    Button hear;
    String[] cwords = {"aegis", "asterisk", "almunae", "archipelago", "chimera", "etcetera", "lambaste", "larvae", "mischievous", "pronounce", "pronounciation", "mispronounce", "mispronunciation", "nuptial", "primer", "prerogative", "peremptory", "realtor", "triathlon", "tenet", "subtle", "chaos", "albeit", "lettuce", "caveat", "colonel", "lieutenant", "gauge", "Yosemite", "Bayesian", "paradigm", "debris", "infamous", "epitome", "facade", "awry", "quay", "queer", "niche", " Caucasus", "mayonnaise", "mauve", "ostensibly", " parliament", " pernickety", " suite", " supremacist", " voluptuous", "Isthmus", "Anemone", "Choir", " Worcestershire", "thistle", "onomatopoeia", "deterioration", "assailant", "Anesthetize", "Sesquipedalian", "Entrepreneur", "Miscellaneous", "accessory", "heinous", "ophthalmologist", "ostensibly", "Tijuana", "yolk", "razzmatazz", "impetuous", "pabulum", "intransigent", "abjure", "aioli", "anamnesis", "truss", "solecism", "fetial", "profligacy", "paregmenon", "consternation", "xenophilia", "ruck", "ensconce", "aphotic", "flummox", "raiment", "mulct", "adulate",

            "buncombe", "comport", "aspersion", "asperity", "imprimatur", "calumniate", "puissance", "depredation", "PUSILLANIMOUS", "numen", "besot", "mensch", "sudorific", "pother", "cicatrix", "obtest", "sibilant", "spondulics", "liturgical", "imbue", "prorogue", "intromit", "omphalos", "prague", "eunuch", "accede", "accost", "alacrity", "alias", "amorphous", "anachronistic", "annex", "apocryphal", "arboreal", "archetypal", "ascetic", "assiduous", "beguile", "bereft", "bilk", "cajole", "jojoba", "camaraderie", "carouse", "caucus", "contentious", "demagogue", "diaphanous", "didactic", "dirge", "dour", "duress", "eclectic", "ebullient", "egregious", "elegy", "epistolary", "fallacious", "fatuous", "fortuitous", "gourmand", "genre", "gratuitous", "hegemony", "impecunious", "inchoate", "chivalry", "charades", "largesse", "legerdemain", "licentious", "morass", "nadir", "neophyte", "ostracism", "panacea", "paucity", "phlegmatic", "pugnacious", "quaint", "quixotic", "redoubtable", "serendipity", "solipsism", "staid", "surfeit", "tome", "toady", "trite", "umbrage", "vicissitude", "wanton", "zephyr", "tirade"};
    TextToSpeech tts;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real);
        hear = (Button) findViewById(R.id.hear);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.auto);
        word = (EditText) findViewById(R.id.realedit);
        Arrays.sort(cwords);
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                Toast.makeText(Real.this, "Started!", Toast.LENGTH_SHORT).show();
            }
        });
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,cwords);
        autoCompleteTextView.setAdapter(arrayAdapter);
        autoCompleteTextView.setDropDownBackgroundDrawable(new ColorDrawable(getBaseContext().getResources().getColor(R.color.hint)));
        autoCompleteTextView.setThreshold(0);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String speech1=autoCompleteTextView.getText().toString();
                tts.speak(speech1,RESULT_OK,null);
                tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float)0.5);
                autoCompleteTextView.setText("");
            }
        });

        hear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String speech = word.getText().toString();
                tts.speak(speech, RESULT_OK, null);
                tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate((float)0.5);
                word.setText("");
            }
        });
    }

}
