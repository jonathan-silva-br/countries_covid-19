package com.example.treinamento.view.adapter;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractAdapter<T, HOLDER extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<HOLDER> {

    protected List<T> itens = new ArrayList<>();

    public AbstractAdapter(List<T> itens){
        this.itens = itens;
    }

    public void setItens(Collection<T> itens){
        if(itens == null){
            this.itens.clear();
        }else{
            this.itens = new ArrayList<>(itens);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return itens.size();
    }
}
