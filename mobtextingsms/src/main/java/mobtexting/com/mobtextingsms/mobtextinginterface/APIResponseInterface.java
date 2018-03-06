package mobtexting.com.mobtextingsms.mobtextinginterface;

/**
 * Created by Dhananjay Gupta on 3/6/2018.
 */

public interface APIResponseInterface {
    void onSuccessResponse(String response);
    void onFailureResponse(String response);
}
