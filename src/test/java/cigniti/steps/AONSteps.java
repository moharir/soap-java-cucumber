package cigniti.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import cigniti.utils.JSONHelper;
import cigniti.utils.RESTAssuredAPI;
import io.cucumber.java.en.When;

public class AONSteps {

	@When("^I verify the AON response contains the word \"(.*?)\"$")
	public void iVerifyAONResponse(String word) {
		String wordfromresponse = RESTAssuredAPI.globalResponse.asString();
		try {
			System.out.println(wordfromresponse);
			wordfromresponse = JSONHelper.xmlAsJson(wordfromresponse).getJSONObject("soap12:Envelope")
					.getJSONObject("soap:Body").getJSONObject("DefineResponse").getJSONObject("DefineResult")
					.getString("Word");
			assertThat(wordfromresponse, hasToString(word));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
