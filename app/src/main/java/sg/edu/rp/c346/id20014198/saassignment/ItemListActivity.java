package sg.edu.rp.c346.id20014198.saassignment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {

    EditText productdesc;
    EditText newproductdesc;
    TextView tvexpiry;
    DatePicker dp;
    Button buttonAdd;
    Button buttonDelete;
    Button buttonUpdate;
    ArrayList<Item> alproducts;
    ArrayAdapter<Item> aaproduct;
    Spinner expiryMonth;
    ListView lv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemlist);


        productdesc = findViewById(R.id.productDesc);
        newproductdesc = findViewById(R.id.newProductDesc);
        buttonAdd = findViewById(R.id.buttonAdd);
        buttonDelete = findViewById(R.id.buttonDelete);
        buttonUpdate = findViewById(R.id.buttonUpdate);
        tvexpiry = findViewById(R.id.tvExpiry);
        dp = findViewById(R.id.datePicker);
        lv = findViewById(R.id.lv);
        expiryMonth = findViewById(R.id.expiryMonth);

        productdesc.setVisibility(View.GONE);
        newproductdesc.setVisibility(View.GONE);
        tvexpiry.setVisibility(View.GONE);
        dp.setVisibility(View.GONE);
        expiryMonth.setVisibility(View.GONE);
        buttonAdd.setVisibility(View.GONE);
        buttonDelete.setVisibility(View.GONE);
        buttonUpdate.setVisibility(View.GONE);

        alproducts = new ArrayList<>();
        Item products = new Item("Expires", 2021, 10, 4, "Ayam Brand Sardine");
        alproducts.add(products);

        products = new Item("Expires", 2022, 6, 15, "Ayam Brand Baked Beans");
        alproducts.add(products);

        products = new Item("Expires", 2021, 8, 30, "Gardenia Bread");
        alproducts.add(products);

        products = new Item("Expires", 2022, 1, 1, "KoKoCrunch Cereal");
        alproducts.add(products);

        products = new Item("Expires", 2021, 9, 30, "Sadia Frozen Chicken");
        alproducts.add(products);

        aaproduct = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, alproducts);
        lv.setAdapter(aaproduct);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedFromList =(lv.getItemAtPosition(position).toString());
                productdesc.setText(selectedFromList);
                for (int i = 0; i < alproducts.size(); i++) {
                    Item item = alproducts.get(i);
                    if (item.toString().equals(productdesc.getText().toString())) {
                        dp.updateDate(item.getYear(), item.getMonth()-1, item.getDay());

                    }
                }
            }


        });


        if (id == R.id.ViewList) {
            productdesc.setVisibility(View.GONE);
            newproductdesc.setVisibility(View.GONE);
            tvexpiry.setVisibility(View.GONE);
            dp.setVisibility(View.GONE);
            expiryMonth.setVisibility(View.VISIBLE);
            buttonAdd.setVisibility(View.GONE);
            buttonDelete.setVisibility(View.GONE);
            buttonUpdate.setVisibility(View.GONE);

            expiryMonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    switch (position) {
                        case 0:
                            aaproduct = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, alproducts);
                            lv.setAdapter(aaproduct);
                            break;
                        case 1:
                            ArrayList<Item> blproducts = new ArrayList<>();
                            for (Item i : alproducts) {
                                if (i.getMonth() == (month + 2)) {
                                    blproducts.add(i);
                                } else if (i.getMonth() == (month - 10) && (i.getYear() == year + 1)) {
                                    blproducts.add(i);
                                }
                                aaproduct = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, blproducts);
                            }
                            lv.setAdapter(aaproduct);
                            break;
                        case 2:
                            blproducts = new ArrayList<>();
                            for (Item i : alproducts) {
                                if (i.getMonth() == (month + 4)) {
                                    blproducts.add(i);
                                } else if (i.getMonth() == (month - 8) && (i.getYear() == year + 1)) {
                                    blproducts.add(i);
                                }
                                aaproduct = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, blproducts);
                            }
                            lv.setAdapter(aaproduct);
                            break;
                        case 3:
                            blproducts = new ArrayList<>();
                            for (Item i : alproducts) {
                                if (i.getMonth() == (month - 5) && (i.getYear() == year + 1)) {
                                    blproducts.add(i);
                                } else if (i.getMonth() == (month + 6)) {
                                    blproducts.add(i);
                                }
                                aaproduct = new ArrayAdapter<>(ItemListActivity.this, android.R.layout.simple_list_item_1, blproducts);
                            }
                            lv.setAdapter(aaproduct);
                    }


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
            return true;
        } else if (id == R.id.Add) {
            productdesc.setHint(getString(R.string.typenew));
            expiryMonth.setVisibility(View.GONE);
            productdesc.setVisibility(View.VISIBLE);
            newproductdesc.setVisibility(View.GONE);
            tvexpiry.setVisibility(View.VISIBLE);
            dp.setVisibility(View.VISIBLE);
            buttonAdd.setEnabled(true);
            buttonAdd.setVisibility(View.VISIBLE);
            buttonDelete.setVisibility(View.GONE);
            buttonUpdate.setVisibility(View.GONE);
            productdesc.setText("");


            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String productName = productdesc.getText().toString();
                    int year = dp.getYear();
                    int month = dp.getMonth() + 1;
                    int day = dp.getDayOfMonth();
                    Item products = new Item("Expires", year, month, day, productName);
                    Calendar c = Calendar.getInstance();
                    int currentyear = c.get(Calendar.YEAR);
                    int currentmonth = c.get(Calendar.MONTH);
                    if (month <= currentmonth && year <= currentyear) {
                        Toast.makeText(ItemListActivity.this, "The Expiry Date Set Has Already Passed!", Toast.LENGTH_SHORT).show();

                    } else {
                        alproducts.add(products);
                        Collections.sort(alproducts);
                        aaproduct.notifyDataSetChanged();
                        productdesc.setText("");
                        Toast.makeText(ItemListActivity.this, "New Product Has Been Added!", Toast.LENGTH_SHORT).show();
                    }

                }
            });
            return true;
        } else if (id == R.id.Remove) {
            productdesc.setHint(getString(R.string.typenew));
            productdesc.setVisibility(View.VISIBLE);
            newproductdesc.setVisibility(View.GONE);
            tvexpiry.setVisibility(View.GONE);
            dp.setVisibility(View.GONE);
            expiryMonth.setVisibility(View.GONE);
            buttonAdd.setVisibility(View.GONE);
            buttonDelete.setEnabled(true);
            buttonDelete.setVisibility(View.VISIBLE);
            buttonUpdate.setVisibility(View.GONE);
            productdesc.setText("");



            buttonDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(ItemListActivity.this);

                    myBuilder.setTitle("Confirm Delete?");
                    myBuilder.setMessage("Once deleted, it cannot be recovered.");
                    myBuilder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            for (int i = 0; i<alproducts.size();i++) {
                                Item s = alproducts.get(i);
                                if (s.toString().equalsIgnoreCase(productdesc.getText().toString())) {
                                    alproducts.remove(i);
                                    aaproduct.notifyDataSetChanged();
                                    productdesc.setText("");
                                    Toast.makeText(ItemListActivity.this, "Product Has Been Removed From The List", Toast.LENGTH_SHORT).show();
                                }
                            }

                        }
                    });

                    myBuilder.setNeutralButton("Cancel", null);

                    myBuilder.show();
                }
            });





            return true;

        }


        else if (id == R.id.Update) {
            productdesc.setVisibility(View.VISIBLE);
            productdesc.setHint(getString(R.string.click));
            newproductdesc.setVisibility(View.VISIBLE);
            tvexpiry.setVisibility(View.VISIBLE);
            dp.setVisibility(View.VISIBLE);
            expiryMonth.setVisibility(View.GONE);
            buttonAdd.setVisibility(View.GONE);
            buttonDelete.setVisibility(View.GONE);
            buttonUpdate.setEnabled(true);
            buttonUpdate.setVisibility(View.VISIBLE);
            productdesc.setText("");

            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedFromList =(lv.getItemAtPosition(position).toString());
                    productdesc.setText(selectedFromList);
                    String productView = productdesc.getText().toString();
                    String productName = productView.substring(18);
                    newproductdesc.setText(productName);
                    for (int i = 0; i < alproducts.size(); i++) {
                        Item item = alproducts.get(i);
                        if (item.toString().equals(productdesc.getText().toString())) {
                            dp.updateDate(item.getYear(), item.getMonth()-1, item.getDay());

                        }
                    }
                }


            });

            buttonUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder myBuilder = new AlertDialog.Builder(ItemListActivity.this);

                    myBuilder.setTitle("Confirm Update?");
                    myBuilder.setMessage("Once Updated, it cannot be reverted.");
                    myBuilder.setPositiveButton("Update", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            int newyear = dp.getYear();
                            int newmonth = dp.getMonth() + 1;
                            int newday = dp.getDayOfMonth();

                            String productView = productdesc.getText().toString();
                            String productName = productView.substring(18);

                            for (int i = 0; i < alproducts.size(); i++) {
                                Item s = alproducts.get(i);
                                String newproductName = newproductdesc.getText().toString();
                                if (s.toString().equals(productView)) {

                                    if (s.getDesc().equals(productName)) {

                                        if (productName.equalsIgnoreCase(newproductName)) {
                                            Item products = new Item(s.getExp(), newyear, newmonth, newday, productName);
                                            alproducts.set(i, products);
                                            Collections.sort(alproducts);
                                            aaproduct.notifyDataSetChanged();
                                            productdesc.setText("");
                                            newproductdesc.setText("");
                                            Toast.makeText(ItemListActivity.this, "Product Name And Date Has Been Updated!", Toast.LENGTH_SHORT).show();
                                        }
                                        else if (newmonth >= s.getMonth() && newyear >= s.getYear() && !productName.equals(newproductName)) {
                                            Item products = new Item(s.getExp(), newyear, newmonth, newday, newproductName);
                                            alproducts.set(i, products);
                                            Collections.sort(alproducts);
                                            aaproduct.notifyDataSetChanged();
                                            productdesc.setText("");
                                            newproductdesc.setText("");
                                            Toast.makeText(ItemListActivity.this, "Product Name And Date Has Been Updated!", Toast.LENGTH_SHORT).show();
                                        } else if (newmonth <= s.getMonth() && newyear <= s.getYear() && !productName.equals(newproductName)) {
                                            Item products = new Item(s.getExp(), newyear, newmonth, newday , newproductName);
                                            alproducts.set(i, products);
                                            Collections.sort(alproducts);
                                            aaproduct.notifyDataSetChanged();
                                            productdesc.setText("");
                                            newproductdesc.setText("");
                                            Toast.makeText(ItemListActivity.this, "Product Name And Date Has Been Updated!", Toast.LENGTH_SHORT).show();

                                        } else {
                                            Toast.makeText(ItemListActivity.this, "Product Not Found!", Toast.LENGTH_SHORT).show();

                                        }

                                    }
                                }

                            }

                        }
                    }).setNeutralButton("Cancel", null);

                    myBuilder.show();
                }
            });

            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
