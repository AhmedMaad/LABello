package com.example.labello.testslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.labello.R;

import java.util.ArrayList;

public class TestsActivity extends AppCompatActivity implements TestsLibraryAdapter.OnItemClickListener{

    private ArrayList<TestsLibraryModel> models = new ArrayList<>();
    private ArrayList<TestsLibraryModel> searchList = new ArrayList<>();
    private TestsLibraryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tests);

        models.add(new TestsLibraryModel("TORCH panel", R.drawable.cbc
                , "TORCH 5 Panel test is a blood test, which is utilized for detecting the presence of antibodies (immunoglobulins IgG and IgM) against the infections in the TORCH panel in the blood. "
                , "No pre-requisites needed.", "Blood sample.", " Your doctor can prescribe this test for diagnosing the cause of recurrent miscarriages and infections which could harm the embryo during pregnancy."
                , "Within 24 hours.", "As your healthcare practitioner wants to detect of Toxoplasma, Rubella, CMV, herpes simplex virus (I &II) IgGs and IgMs."));

        models.add(new TestsLibraryModel("Semen examination", R.drawable.hemoglobin, "It measures the quantity and quality of the fluid released during ejaculation. It is often used in the evaluation of male infertility."
                , "For infertility testing, refrain from having sex or masturbation for 2-5 days before sample collection.",
                "A semen sample collected in a sterile, wide-mouth container provided by the lab; often collected on-site, but sometimes it may be collected at home using a special condom obtained from a healthcare practitioner.",
                "A semen analysis is performed when a healthcare practitioner thinks that a man or couple might have a fertility problem or about three months after you have had a vasectomy."
                , "It takes from 30 to an hour.",
                "As part of infertility testing if your partner is having trouble becoming pregnant or after a vasectomy to determine if the operation was successful."));

        models.add(new TestsLibraryModel("Toxo IgG & IgM", R.drawable.liver, "When someone is exposed to T. gondii, their immune system responds by producing antibodies to the parasite. Two classes of Toxoplasma antibodies may be found in the blood: IgM and IgG.",
                "No pre-requisites needed.", "A blood sample drawn from a vein\n" +
                "a cerebrospinal fluid (CSF) sample is collected from the lower back or spinal tap or an amniotic fluid sample is collected from a pregnant woman using amniocentesis.\n"
                , "T. gondii antibody testing is not routinely ordered on pregnant women but may be ordered when a healthcare practitioner wants to determine if a woman has previously had toxoplasmosis and when she has been exposed to cat feces (stool), raw or undercooked meat, or contaminated food or water.\n" +
                "Antibody testing may be ordered for a person with a weakened immune system, when the person has symptoms:\n" +
                "•\tSwollen lymph nodes\n" +
                "•\tFever, night sweats\n" +
                "•\tWeakness, fatigue\n" +
                "•\tHeadache\n" +
                "•\tBody aches\n" +
                "•\tSometimes a sore throat\n"
                , "IgM and IgG are detected in serum within 1 to 2 weeks.", "When a pregnant woman or a person with a weakened immune system has been exposed to T. gondii and/or has flu-like symptoms or a severe eye or brain infection that a healthcare practitioner suspects are due to toxoplasmosis."));

        models.add(new TestsLibraryModel("IgE Total", R.drawable.creatinine, "This test measures the amount of IgE in the blood. To screen for an allergic disease; sometimes to screen for a parasitic infection."
                , "No pre-requisites needed.", "A blood sample drawn from a vein in your arm.",
                "When you have periodic or persistent skin, lung, or digestive symptoms that suggest allergies; when a healthcare practitioner suspects a parasitic infection. Symptoms may include:\n" +
                        "•\tPeriodic or persistent itching\n" +
                        "•\tHives\n" +
                        "•\tItchy eyes\n" +
                        "•\tEczema\n" +
                        "•\tNausea, vomiting, persistent diarrhea\n" +
                        "•\tSneezing, coughing, congestion\n" +
                        "•\tDifficulty breathing\n" +
                        "•\tAsthma symptoms: wheezing, breathlessness, coughing, tightness in the chest\n"
                , "it may take a few days for the results to be available.", "N/A"));

        models.add(new TestsLibraryModel("Widal Test", R.drawable.antigen, "The Widal test is one method that may be used to help make a presumptive diagnosis of enteric fever, also known as typhoid fever."
                , "No pre-requisites needed.", "A blood sample could be taken from a vein in your arm. Testing for enteric fever usually involves a blood culture to detect the bacteria during the first week of fever. A Stool, urine or bone marrow culture may also be performed."
                , "If you have symptoms of a typhoid fever. It is associated with symptoms that include high fever, headache, abdominal pain, diarrhea, and a rash known as \"rose Spots.\"",
                "N/A", "Used to help make a presumptive diagnosis of enteric fever, also known as typhoid fever."));

        models.add(new TestsLibraryModel("Monospot Test", R.drawable.heart, "N/A", "No pre-requisites needed."
                , "A blood sample taken from a vein in your arm", "If you have symptoms of mononucleosis, including fever, sore throat, swollen glands, and fatigue.",
                "N/A", "To get screened for infectious mononucleosis (glandular fever)."));

        models.add(new TestsLibraryModel("Rubella Test", R.drawable.cardiac, "Rubella is a contagious viral infection best known by its distinctive red rash. It's also called German measles or three-day measles. While this infection may cause mild symptoms or even no symptoms in most people, it can cause serious problems for unborn babies whose mothers become infected during pregnancy."
                , "No pre-requisites needed.", "A blood sample drawn from a vein in the arm of an adult or blood drawn from a heelprick or from the umbilical cord of a newborn.",
                "If you're considering getting pregnant, check your vaccination record to make sure you've received your MMR vaccine. If you're pregnant and you develop rubella, especially during your first trimester, the virus can cause death or serious birth defects in the developing fetus. Signs and symptoms generally appear between two and three weeks after exposure to the virus. They usually last about one to five days and may include:\n" +
                        "•\tMild fever of 102 F (38.9 C) or lower\n" +
                        "•\tHeadache\n" +
                        "•\tStuffy or runny nose\n" +
                        "•\tInflamed, red eyes\n" +
                        "•\tEnlarged, tender lymph nodes at the base of the skull, the back of the neck and behind the ears\n" +
                        "•\tA fine, pink rash that begins on the face and quickly spreads to the trunk and then the arms and legs, before disappearing in the same sequence\n" +
                        "•\tAching joints, especially in young women\n"
                , "Undefined.", "To determine if you have sufficient rubella antibodies to protect you from the rubella virus; to verify a past infection or detect a recent infection."));

        models.add(new TestsLibraryModel("Anti-Ribonucleoprotein (Anti RNP)", R.drawable.urine, "N/A"
                , "No pre-requisites needed.", "A blood sample drawn from a vein in your arm."
                , "When your ANA (Antinuclear Antibody) test is positive; when you have symptoms that suggest an autoimmune disorder."
                , "6 days.", "To help diagnose and distinguish between autoimmune disorders."));

        models.add(new TestsLibraryModel("Complete Blood Count (CBC)", R.drawable.blood_urine, "The complete blood count (CBC) is a group of tests that evaluate the cells that circulate in blood, including red blood cells (RBCs), white blood cells (WBCs), and platelets (PLTs). The CBC can evaluate your overall health and detect a variety of diseases and conditions, such as infections, anemia and leukemia."
                , "No prerequisites needed", "A blood sample drawn from a vein in your arm or a fingerstick or heelstick (newborns"
                , "As part of a routine medical exam; when you have signs and symptoms that may be related to a condition that affects blood cells; at regular intervals to monitor treatment or disease status or when you are receiving treatment known to affect blood cells.\n" +
                "A CBC may be ordered when you are ill and/or have signs and symptoms that may be related to conditions that affect blood cells. The test may be ordered when you have fatigue or weakness, or easy bruising or bleeding, or when you have signs and symptoms suggesting an infection or inflammation, to name a few examples.\n"
                , "24 hours.", "To determine your general health status; to screen for, diagnose, or monitor any one of a variety of diseases and conditions that affect blood cells, such as anemia, infection, inflammation, bleeding disorder or cancer."));

        models.add(new TestsLibraryModel("Stool test", R.drawable.glucose, "A stool analysis is a series of tests done on a stool (feces) sample to help diagnose certain conditions affecting the digestive tract. These conditions can include infection (such as from parasites, viruses, or bacteria), poor nutrient absorption, or cancer."
                , "No prerequisites needed", "A blood sample drawn from a vein in your arm or a fingerstick or heelstick (newborns)"
                , "As part of a routine medical exam; when you have signs and symptoms that may be related to a condition that affects blood cells; at regular intervals to monitor treatment or disease status or when you are receiving treatment known to affect blood cells.\n" +
                "A CBC may be ordered when you are ill and/or have signs and symptoms that may be related to conditions that affect blood cells. The test may be ordered when you have fatigue or weakness, or easy bruising or bleeding, or when you have signs and symptoms suggesting an infection or inflammation, to name a few examples.\n"
                , "24 hours.", "To determine your general health status; to screen for, diagnose, or monitor any one of a variety of diseases and conditions that affect blood cells, such as anemia, infection, inflammation, bleeding disorder or cancer."));

        adapter = new TestsLibraryAdapter(this, models);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setAdapter(adapter);

        /*adapter.setOnItemClickListener(new TestsLibraryAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(TestsActivity.this, TestsLibraryDetailsActivity.class);
                i.putExtra("details", models.get(position));
                startActivity(i);
            }
        });*/

        adapter.setOnItemClickListener(this);

        EditText searchET = findViewById(R.id.et_search);
        searchET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchList.clear();
                for (TestsLibraryModel test : models) {
                    if (test.getName().toLowerCase().contains(s.toString().toLowerCase())) {
                        searchList.add(test);
                    }
                }
                adapter = new TestsLibraryAdapter(TestsActivity.this, searchList);
                rv.setAdapter(adapter);
                adapter.setOnItemClickListener(TestsActivity.this);
            }
        });

    }

    @Override
    public void onClick(TestsLibraryModel test) {
        Intent i = new Intent(TestsActivity.this, TestsLibraryDetailsActivity.class);
        i.putExtra("details", test);
        startActivity(i);
    }
}