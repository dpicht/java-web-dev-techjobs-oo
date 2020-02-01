package org.launchcode.techjobs_oo.tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job newJob;
    Job secondJob;

    @Before
    public void createJob() {
        newJob = new Job();
        secondJob = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertTrue(secondJob.getId() == newJob.getId() + 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJob instanceof Job);
    }

    @Test
    public void testJobsForEquality() {
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJobOne.equals(testJobTwo));
    }

    @Test
    public void testDisplayCategory() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" +
                "ID: " + testJob.getId() + "\n" +
                "Name: " + testJob.getName() + "\n" +
                "Employer: " + testJob.getEmployer() + "\n" +
                "Location: " + testJob.getLocation() + "\n" +
                "Position Type: " + testJob.getPositionType() + "\n" +
                "Core Competency: " + testJob.getCoreCompetency() + "\n",
                testJob.toString());
    }

    @Test
    public void testEmptyField() {
        Job testJob = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" +
                        "ID: " + testJob.getId() + "\n" +
                        "Name: " + testJob.getName() + "\n" +
                        "Employer: Data Not Available" + "\n" +
                        "Location: " + testJob.getLocation() + "\n" +
                        "Position Type: " + testJob.getPositionType() + "\n" +
                        "Core Competency: " + testJob.getCoreCompetency() + "\n",
                        testJob.toString());
    }
}
