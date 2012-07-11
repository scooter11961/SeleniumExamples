package com.mapquest.vibe.uitest;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.runners.Suite;
import org.junit.runners.model.*;

import com.mapquest.vibe.util.PropertyLoader;

/*
 * This was created by Leonardo for Selenium1 and jUnit 
 * to extend the test framework for parallel test execution.
 * Hopefully we no longer need this
 */
public class Parallelized extends Suite
{
    
    private static class ThreadPoolScheduler implements RunnerScheduler
    {
        private ExecutorService executor; 
 
        public ThreadPoolScheduler()
        {
            Properties uiTestProps = null;
            try {
                Properties props = new PropertyLoader().
                        load(TestRoot.class.getResourceAsStream(
                        "uitest.properties"));
                
                InputStream stream=TestRoot.class.getResourceAsStream(
                        "local-uitest.properties");
                if (stream!=null) {
                    uiTestProps = new PropertyLoader().load(stream, props);
                } else {
                    uiTestProps = props;
                }
            } catch (Exception e) {
                //TODO... log errors
                //logger.error("unable to load override file:",e);
            }
            
            String uitestSeleniumThreads=System.getProperty("UITEST.SELENIUM.THREADS");
            if (uitestSeleniumThreads==null) {
            	uitestSeleniumThreads=uiTestProps.getProperty("UITEST.SELENIUM.THREADS", "1");
            }
            int numThreads = Integer.parseInt(uitestSeleniumThreads);
            executor = Executors.newFixedThreadPool(numThreads);
        }
        

        public void finished()
        {
            executor.shutdown();
            try
            {
                executor.awaitTermination(7*60*60, TimeUnit.SECONDS);  // 7 hours timeout
            }
            catch (InterruptedException exc)
            {
                throw new RuntimeException(exc);
            }
        }

        
        public void schedule(Runnable childStatement)
        {
            executor.submit(childStatement);
        }
    }

    public Parallelized(Class klass, RunnerBuilder builder) throws Throwable
    {
        super(klass, builder);
    	setScheduler(new ThreadPoolScheduler());
    }
}
