
package com.framework.core;

import com.google.inject.Injector;
import org.testng.*;
import org.testng.internal.annotations.IAnnotationFinder;
import org.testng.xml.XmlSuite;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SeleniumTestsDefaultSuite implements ISuite {

    private static final long serialVersionUID = -152933123712833411L;
    private final XmlSuite xmlSuite;

    public SeleniumTestsDefaultSuite() {
        this.xmlSuite = new DefaultXmlSuite();
    }

    public Object getAttribute(final String name) {
        return null;
    }

    public void setAttribute(final String name, final Object value) { }

    public Set<String> getAttributeNames() {
        return null;
    }

    public Object removeAttribute(final String name) {
        return null;
    }

    public String getName() {
        return "Default suite";
    }

    public Map<String, ISuiteResult> getResults() {
        return null;
    }

    public IObjectFactory getObjectFactory() {
        return null;
    }

    public IObjectFactory2 getObjectFactory2() {
        return null;
    }

    public String getOutputDirectory() {
        return null;
    }

    public String getParallel() {
        return null;
    }

    public String getParentModule() {
        return null;
    }

   
    public String getGuiceStage() {
        return null;
    }

    public String getParameter(final String parameterName) {
        return null;
    }

    public Map<String, Collection<ITestNGMethod>> getMethodsByGroups() {
        return null;
    }

    public Collection<ITestNGMethod> getInvokedMethods() {
        return null;
    }

    public List<IInvokedMethod> getAllInvokedMethods() {
        return null;
    }

    public Collection<ITestNGMethod> getExcludedMethods() {
        return null;
    }

    public void run() { }

    public String getHost() {
        return null;
    }

    public SuiteRunState getSuiteState() {
        return null;
    }

    public IAnnotationFinder getAnnotationFinder() {
        return null;
    }

    public XmlSuite getXmlSuite() {
        return xmlSuite;
    }

    public void addListener(final ITestNGListener listener) { }

    
    public Injector getParentInjector() {
        return null;
    }

    public void setParentInjector(final Injector injector) {

    }

    public List<ITestNGMethod> getAllMethods() {
        return null;
    }

}
