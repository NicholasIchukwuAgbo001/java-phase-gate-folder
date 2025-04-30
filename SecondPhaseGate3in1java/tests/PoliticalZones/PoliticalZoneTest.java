package PoliticalZones;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PoliticalZoneTest {

    @Test
    public void testNorthCentralZone() {
        assertEquals(PoliticalZone.NORTH_CENTRAL, PoliticalZone.getZone("Benue"));
    }

    @Test
    public void testNorthEastZone() {
        assertEquals(PoliticalZone.NORTH_EAST, PoliticalZone.getZone("Adamawa"));
    }

    @Test
    public void testNorthWestZone() {
        assertEquals(PoliticalZone.NORTH_WEST, PoliticalZone.getZone("Kaduna"));
    }

    @Test
    public void testSouthEastZone() {
        assertEquals(PoliticalZone.SOUTH_EAST, PoliticalZone.getZone("Abia"));
    }

    @Test
    public void testSouthSouthZone() {
        assertEquals(PoliticalZone.SOUTH_SOUTH, PoliticalZone.getZone("Edo"));
    }

    @Test
    public void testSouthWestZone() {
        assertEquals(PoliticalZone.SOUTH_WEST, PoliticalZone.getZone("Lagos"));
    }
  
}