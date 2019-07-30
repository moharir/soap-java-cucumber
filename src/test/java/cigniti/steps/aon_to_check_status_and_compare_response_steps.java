package cigniti.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import cigniti.utils.JSONHelper;
import cigniti.utils.RESTAssuredAPI;
import io.cucumber.java.en.When;

public class aon_to_check_status_and_compare_response_steps {

	@When("^I verify the AON response contains the word \"(.*?)\"$")
	public void iVerifyAONResponse(String word) {
		String wordfromresponse = RESTAssuredAPI.globalResponse.asString();
		try {
			wordfromresponse = JSONHelper.xmlAsJson(wordfromresponse).getJSONObject("soap12:Envelope")
					.getJSONObject("soap:Body").getJSONObject("DefineResponse").getJSONObject("DefineResult")
					.getString("Word");
			assertThat(wordfromresponse, hasToString(word));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
