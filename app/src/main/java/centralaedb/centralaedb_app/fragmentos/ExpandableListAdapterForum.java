package centralaedb.centralaedb_app.fragmentos;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import centralaedb.centralaedb_app.Model.ComentarioDaTimeline;
import centralaedb.centralaedb_app.Model.Timeline;
import centralaedb.centralaedb_app.R;


public class ExpandableListAdapterForum extends BaseExpandableListAdapter{

    private Context context;
    private HashMap<String, List<String>> submateria;
    private List<String> materia;


    public ExpandableListAdapterForum(Context context, HashMap<String, List<String>> hashMap , List<String> parent){

        this.context = context;
        this.submateria = hashMap;
        this.materia = parent;


    }

    @Override
    //counts the number of group/parent items so the list knows how many times calls getGroupView() method
    public int getGroupCount() {
        return materia.size();
    }

    @Override
    //counts the number of children items so the list knows how many times calls getChildView() method
    public int getChildrenCount(int i) {

        String j = materia.get(i);

        //int index = j.indexOf("-") + 2;

        //String sub = j.substring(index,j.length());

        List<String> k = submateria.get(j);

        int l = k.size();


        return l;
    }

    @Override
    //gets the title of each parent/group
    public Object getGroup(int i) {

        return this.materia.get(i);
    }

    @Override
    //gets the name of each item
    public Object getChild(int i, int i1) {

        String j = materia.get(i);

        //int index = j.indexOf("-") + 2;

        //tring sub = j.substring(index, j.length());

        List<String> k = submateria.get(j);

        String l =  k.get(i1);

        return l;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    //in this method you must set the text to see the parent/group on the list
    public View getGroupView(int groupPosition, boolean b, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        holder.groupPosition = groupPosition;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_forum, viewGroup,false);
        }


        String group = (String)getGroup(groupPosition).toString();

        TextView textView = (TextView) view.findViewById(R.id.tvNomeMateria);

        textView.setText(group);


        //view.setTag(holder);

        //return the entire view
        return view;
    }

    @Override
    //in this method you must set the text to see the children on the list
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {

        ViewHolder holder = new ViewHolder();
        holder.childPosition = childPosition;
        holder.groupPosition = groupPosition;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater)this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.child_forum, viewGroup,false);
        }
/*
        TextView textView = (TextView) view.findViewById(R.id.textViewChild);
        textView.setText(timeline.get(groupPosition).getArrayChildren().get(childPosition));

        view.setTag(holder);
*/
        String childName = (String)getChild(groupPosition, childPosition);

        TextView childItem = (TextView)view.findViewById(R.id.tvSubMateria);

        childItem.setText(childName);

        //return the entire view
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {
        /* used to make the notifyDataSetChanged() method work */
        super.registerDataSetObserver(observer);
    }

// Intentionally put on comment, if you need on click deactivate it
/*  @Override
    public void onClick(View view) {
        ViewHolder holder = (ViewHolder)view.getTag();
        if (view.getId() == holder.button.getId()){

           // DO YOUR ACTION
        }
    }*/


    protected class ViewHolder {
        protected int childPosition;
        protected int groupPosition;
        protected Button button;
    }

}
