package com.cseur.xlsService;

import com.cseur.profile.ConfigReader;
import com.cseur.profile.XlsFileConfig;
import java.io.File;
import org.apache.commons.beanutils.BeanUtils;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Separate Java service class. Backend implementation for the address book
 * application, with "detached entities" simulating real world DAO. Typically
 * these something that the Java EE or Spring backend services provide.
 */
// Backend service class. This is just a typical Java backend implementation
// class and nothing Vaadin specific.
public class RoutingService {

    // Create dummy data by randomly combining first and last names
    // Create dummy data by randomly combining first and last names
    static String[] portNames = {"DEHAM", "NLRTM", "GBFXT", "BEZEE", "FRLEH",
        "ESVLC", "PTLEI", "PLGDY", "FIHEL", "SEGOT", "DKCOP", "RULED", "LVRIX", ""};

    private static RoutingService instance;

    public static RoutingService createDemoService() {
        File xlsConfig = new File("..\\..\\..\\..\\..\\xlsWorks.conf");
        System.out.print(xlsConfig.isFile());
        List<XlsFileConfig> xlsConfigs = new ConfigReader().getProfile(xlsConfig);
        System.out.print(xlsConfigs.toString());

        if (instance == null) {

            final RoutingService contactService = new RoutingService();

            Random r = new Random(0);
            Calendar cal = Calendar.getInstance();
            for (int i = 0; i < 100; i++) {
                Routing routing = new Routing();
                routing.setPOL(portNames[r.nextInt(portNames.length - 1)]);
                routing.setPOD(portNames[r.nextInt(portNames.length - 1)]);
                routing.setVIA01(portNames[r.nextInt(portNames.length)]);
                routing.setVIA02(portNames[r.nextInt(portNames.length)]);
                routing.setVIA03(portNames[r.nextInt(portNames.length)]);
                routing.setVIA04(portNames[r.nextInt(portNames.length)]);
//not work!
//                String pol = routing.getPOL();
//                routing.setRouteCode(routing.getPOL() + routing.getPOD() + new Random().nextInt(100));
//works!
                routing.setRouteCode(routing.getPOL().substring(2) + routing.getPOD().substring(2) + new Random().nextInt(100));
//                routing.setRouteCode(generateRoutingCode(routing));
                cal.set(1930 + r.nextInt(70),
                        r.nextInt(11), r.nextInt(28));
                routing.setLastUpdateDate(cal.getTime());
                contactService.save(routing);
            }
            instance = contactService;
        }

        return instance;
    }

    private HashMap<Long, Routing> contacts = new HashMap<>();
    private long nextId = 0;

//    private String generateRoutingCode(Routing routing) {
//        String pol=routing.getPOL();
//        System.out.println(pol);
//        return (pol).substring(2) + routing.getPOD() + new Random().nextInt(100);
//    }
    public synchronized List<Routing> findAll(String stringFilter) {
        ArrayList arrayList = new ArrayList<>();
        for (Routing routing : contacts.values()) {
            try {
                boolean passesFilter = (stringFilter == null || stringFilter.isEmpty())
                        || routing.toString().toLowerCase()
                        .contains(stringFilter.toLowerCase());
                if (passesFilter) {
                    arrayList.add(routing.clone());
                }
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(RoutingService.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
        }
        Collections.sort(arrayList, new Comparator<Routing>() {

            @Override
            public int compare(Routing o1, Routing o2) {
                return (int) (o2.getId() - o1.getId());
            }
        });
        return arrayList;
    }

    public synchronized long count() {
        return contacts.size();
    }

    public synchronized void delete(Routing value) {
        contacts.remove(value.getId());
    }

    public synchronized void save(Routing entry) {
        if (entry.getId() == null) {
            entry.setId(nextId++);
        }
        try {
            entry = (Routing) BeanUtils.cloneBean(entry);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        contacts.put(entry.getId(), entry);
    }

}
