package mad.listv;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView ListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //The items are set in the list view progressively, not all of them at the same time

        //Array of type groups
        //In this case we cant use ArrayAdapter, we must create our own adapter
        groups data_groups[] = new groups[]{
                new groups(R.drawable.man, "Group1","Noti1"),
                new groups(R.drawable.man, "Group2","Noti2"),
                new groups(R.drawable.man, "Group3","Noti3"),
                new groups(R.drawable.woman, "Group4","Noti4"),
                new groups(R.drawable.man, "Group5","Noti5"),
                new groups(R.drawable.man, "Group6","Noti6"),
                new groups(R.drawable.man, "Group7","Noti7"),
                new groups(R.drawable.man, "Group8","Noti8"),
                new groups(R.drawable.man, "Group9","Noti9"),
        };

        //Creating the adapter
        groups_adapter adapter = new groups_adapter(this, R.layout.listview_item_row, data_groups);
        ListView = (ListView) findViewById(R.id.lista1);

        View header = (View) getLayoutInflater().inflate(R.layout.list_header_row,null);
        //Add the header to the list
        ListView.addHeaderView(header);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView)view.findViewById(R.id.text1);
                Toast.makeText(getApplicationContext(),v.getText(), Toast.LENGTH_SHORT).show();

                switch (position) {

                    case 4:
                        //dont forget to include "show()", otherwise the message wont be showed
                        Toast.makeText(getApplicationContext(), "This is a Toast", Toast.LENGTH_SHORT).show();
                        break;

                    case 5:
                        Intent intent1 = new Intent(MainActivity.this, MainAcitvity2.class);
                        //intent1.putExtra("DATO",dato2);

                        startActivity(intent1);

                        break;


                }

            }
        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
