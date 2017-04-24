package mad.listv;

/**
 * Created by root on 28/03/17.
 */

public class groups {
    public int icon;
    public String title;
    public String noti;

    //Constructor => in case we dont receive anything
    public groups(){
        super();
    }

    //Constructor => in case we receive elements
    public groups(int icon, String title, String noti){
        super();
        this.icon = icon;
        this.title = title;
        this.noti = noti;

    }
}

///////////////////////////////
//Elements will be of this class. Data type: groups