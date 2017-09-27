package com.sample;

import java.util.HashMap;
import java.util.Map;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample file to launch a process.
 */
public class ProcessRuleTest {

	public static final void main(String[] args) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession ksession = kContainer.newKieSession("sample-process-rules");
			
			// set the parameters
			Map<String, Object> params = new HashMap<String, Object>();
			HelloProcessModel hpm = new HelloProcessModel();
			hpm.setCount(new Integer("3"));
			hpm.setUserlocation("NewYorkUser");
			params.put("hpm", hpm);
			ksession.startProcess("looptest777",params);
		
			ksession.fireAllRules();
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	
}