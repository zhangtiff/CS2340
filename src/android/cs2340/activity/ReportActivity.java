package android.cs2340.activity;


import android.cs2340.R;
import android.os.Bundle;
import android.content.Intent;
import android.cs2340.model.ReportModel;
import android.cs2340.presenters.ReportPresenter;
import android.cs2340.views.ReportView;
import android.view.Menu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * The class constructs the page of the spending report.
 * 
 * @author Team 42
 * 
 */
public class ReportActivity extends AbstractActivityFactory implements ReportView {

    /**
     * The Presenter used by the view.
     */
    ReportPresenter presenter;
    
    /**
     * The container showing the report. 
     */
    LinearLayout reportHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        presenter = new ReportPresenter((ReportModel) getIntent().getExtras()
                .getSerializable("theReport"), this);
        reportHolder = (LinearLayout) findViewById(R.id.Report_Holder);

        presenter.drawWrittenReport();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.report, menu);
        return true;
    }
    
    @Override
    public void drawReport(String writtenReport) {
        TextView writtenRep = new TextView(this);
        writtenRep.setText(writtenReport);
        reportHolder.addView(writtenRep);
    }

    /**
     * Hook for when the user clicks the back button.
     * Goes to UserPageActivity.
     * @param view This view.
     */
    public void goBack(View view) {
        presenter.back();
    }

    @Override
    public void goToUserPage(long userId) {
        Intent intent = new Intent(this, UserPageActivity.class);
        intent.putExtra("user_id", userId);
        startActivity(intent);
    }

    // //FIX THIS
    //
    // private Collection<TransactionAbstract> transactions = new
    // ArrayList<TransactionAbstract>();
    // private String start;
    // private String end;
    // private String report = "";
    //
    // @Override
    // public String toString(){
    // String reportByAccount = "";
    // int size = transactions.size();
    // double totalSpending = 0;
    // if (size==0)
    // return "No spending report. ";
    // for (TransactionAbstract transaction : transactions) {
    // String date = transaction.getDateMade();
    // if(compareDates(date,start)>=0 && compareDates(date,end)<=0 ){ //between
    // the date range
    // reportByAccount = reportByAccount + " Spending: " +
    // transaction.getAmount() + " Source: " + transaction.getCatagory() + "\n";
    // totalSpending = totalSpending + transaction.getAmount();
    // }
    // }
    // reportByAccount = reportByAccount + "Total Account Spending: " +
    // totalSpending +"\n";
    // return reportByAccount;
    // }
    //
    // public double compareDates(String dateA, String dateRange){
    // try{
    // SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    // Date date1 = sdf.parse(dateA);
    // Date date2 = sdf.parse(dateRange);
    //
    // if(date1.compareTo(date2)>0){
    // return 1;
    // }else if(date1.compareTo(date2)<0){
    // return -1;
    // }else if(date1.compareTo(date2)==0){
    // return 0;
    // }
    // }catch(ParseException ex){
    // ex.printStackTrace();
    // }
    // return 0;
    // }
    //
    //

}