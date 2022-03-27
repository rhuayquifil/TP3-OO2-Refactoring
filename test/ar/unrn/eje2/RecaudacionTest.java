package ar.unrn.eje2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import ar.unrn.eje2.Recaudacion;
import ar.unrn.eje2.NoSuchEntryException;

public class RecaudacionTest {

  @Test
  public void testWhereGivenCompany() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("company_name", "Facebook");
    Assert.assertEquals(Recaudacion.where(options).size(), 7);
  }

  @Test
  public void testWhereGivenCity() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("city", "Tempe");
    Assert.assertEquals(Recaudacion.where(options).size(), 3);
  }

  @Test
  public void testWhereGivenState() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("state", "CA");
    Assert.assertEquals(Recaudacion.where(options).size(), 873);
  }

  @Test
  public void testWhereGivenRound() {
    try {
      Map<String, String> options = new HashMap<String, String>();
      options.put("round", "a");
      Assert.assertEquals(Recaudacion.where(options).size(), 582);
    } catch (IOException e) {
    }
  }

  @Test
  public void testMultipleOptions() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("round", "a");
    options.put("company_name", "Facebook");
    Assert.assertEquals(Recaudacion.where(options).size(), 1);
  }

  @Test
  public void testWhereNotExists() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("company_name", "NotFacebook");
    Assert.assertEquals(Recaudacion.where(options).size(), 0);
  }

  @Test
  public void testWhereCorrectKeys() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("company_name", "Facebook");
    Map<String, String> row = Recaudacion.where(options).get(0);

    assertEquals(row.get("permalink"), "facebook");
    assertEquals(row.get("company_name"), "Facebook");
    assertEquals(row.get("number_employees"), "450");
    assertEquals(row.get("category"), "web");
    assertEquals(row.get("city"), "Palo Alto");
    assertEquals(row.get("state"), "CA");
    assertEquals(row.get("funded_date"), "1-Sep-04");
    assertEquals(row.get("raised_amount"), "500000");
    assertEquals(row.get("round"), "angel");

  }

  @Test
  public void testFindByGivenCompanyName() throws IOException, NoSuchEntryException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("company_name", "Facebook");
    Map<String, String> row = Recaudacion.findBy(options);

    assertEquals(row.get("permalink"), "facebook");
    assertEquals(row.get("company_name"), "Facebook");
    assertEquals(row.get("number_employees"), "450");
    assertEquals(row.get("category"), "web");
    assertEquals(row.get("city"), "Palo Alto");
    assertEquals(row.get("state"), "CA");
    assertEquals(row.get("funded_date"), "1-Sep-04");
    assertEquals(row.get("raised_amount"), "500000");
    assertEquals(row.get("round"), "angel");
  }

  @Test
  public void testFindByGivenState() throws IOException, NoSuchEntryException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("state", "CA");
    Map<String, String> row = Recaudacion.findBy(options);

    assertEquals(row.get("permalink"), "digg");
    assertEquals(row.get("company_name"), "Digg");
    assertEquals(row.get("number_employees"), "60");
    assertEquals(row.get("category"), "web");
    assertEquals(row.get("city"), "San Francisco");
    assertEquals(row.get("state"), "CA");
    assertEquals(row.get("funded_date"), "1-Dec-06");
    assertEquals(row.get("raised_amount"), "8500000");
    assertEquals(row.get("round"), "b");
  }

  @Test
  public void testFindByMultipleOptions() throws IOException, NoSuchEntryException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("company_name", "Facebook");
    options.put("round", "c");
    Map<String, String> row = Recaudacion.findBy(options);

    assertEquals(row.get("permalink"), "facebook");
    assertEquals(row.get("company_name"), "Facebook");
    assertEquals(row.get("number_employees"), "450");
    assertEquals(row.get("category"), "web");
    assertEquals(row.get("city"), "Palo Alto");
    assertEquals(row.get("state"), "CA");
    assertEquals(row.get("funded_date"), "1-Oct-07");
    assertEquals(row.get("raised_amount"), "300000000");
    assertEquals(row.get("round"), "c");
  }

  @Test
  public void testFindByNotExists() throws IOException {
    Map<String, String> options = new HashMap<String, String>();
    options.put("company_name", "NotFacebook");
    options.put("round", "c");
    try {
      Map<String, String> row = Recaudacion.findBy(options);
      Assert.fail("findBy should throw exception");
    } catch (NoSuchEntryException e) {
      // Esta bien que salga por el catch
    }
  }
}
