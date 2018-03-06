package mobtexting.com.mobtextingsms;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.WindowManager;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkError;
import com.android.volley.NoConnectionError;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

import mobtexting.com.mobtextingsms.mobtextinginterface.APIResponseInterface;
import mobtexting.com.mobtextingsms.mobtextinginterface.VolleySingleton;

/**
 * Created by Dhananjay Gupta on 3/6/2018.
 */

public class MobtextingSMS {
    public static void MobtextingAPICallBackResponse(final APIResponseInterface responseInterface, final Map<String,String> paramVal, final String URL, final int method,
                                                  Context context){
        //show progress dialog
        final ProgressDialog dialog = new ProgressDialog(context, R.style.MyAlertDialogStyle);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {

        }
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.progressdialog);
        dialog.show();

        StringRequest stringRequest = new StringRequest(method, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            dialog.cancel();
                            Log.d("response", response);
                            responseInterface.onSuccessResponse(response);
                        }catch (Exception e){
                            responseInterface.onFailureResponse("Something went wrong!");
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        String message = null;
                        dialog.cancel();

                        if (volleyError instanceof NetworkError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ServerError) {
                            message = "The server could not be found. Please try again after some time!!";
                        } else if (volleyError instanceof AuthFailureError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof ParseError) {
                            message = "Parsing error! Please try again after some time!!";
                        } else if (volleyError instanceof NoConnectionError) {
                            message = "Cannot connect to Internet...Please check your connection!";
                        } else if (volleyError instanceof TimeoutError) {
                            message = "Connection TimeOut! Please check your internet connection.";
                        }

                        if (!(message == null)) {
                            responseInterface.onFailureResponse(message);
                        }
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                for (Map.Entry<String, String> entry : paramVal.entrySet()) {
                    Log.d("valuecall", entry.getKey() + " : " + entry.getValue());
                    paramVal.put(entry.getKey(), entry.getValue());
                }
                return paramVal;
            }
        };


        stringRequest.setRetryPolicy(new DefaultRetryPolicy(
                0,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }
}
