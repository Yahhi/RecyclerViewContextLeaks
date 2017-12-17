package ru.develop_for_android.udacity.recyclerviewcontextleaks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    RecyclerView contextInConstructor, contextInCreate, contextInBind;
    AdapterWithContextInConstructor adapterWithContextInConstructor;
    AdapterWithContextInOnBind adapterWithContextInOnBind;
    AdapterWithContextInOnCreateViewHolder adapterWithContextInOnCreateViewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextInConstructor = findViewById(R.id.context_in_constructor);
        contextInCreate = findViewById(R.id.context_in_on_create_viewholder);
        contextInBind = findViewById(R.id.context_in_on_bind_viewholder);

        contextInConstructor.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        contextInCreate.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        contextInBind.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        adapterWithContextInConstructor = new AdapterWithContextInConstructor(getBaseContext());
        adapterWithContextInOnCreateViewHolder = new AdapterWithContextInOnCreateViewHolder();
        adapterWithContextInOnBind = new AdapterWithContextInOnBind();

        DividerItemDecoration decoration =
                new DividerItemDecoration(getBaseContext(), DividerItemDecoration.VERTICAL);
        contextInConstructor.addItemDecoration(decoration);
        contextInCreate.addItemDecoration(decoration);
        contextInBind.addItemDecoration(decoration);

        contextInConstructor.setAdapter(adapterWithContextInConstructor);
        contextInCreate.setAdapter(adapterWithContextInOnCreateViewHolder);
        contextInBind.setAdapter(adapterWithContextInOnBind);
    }
}
