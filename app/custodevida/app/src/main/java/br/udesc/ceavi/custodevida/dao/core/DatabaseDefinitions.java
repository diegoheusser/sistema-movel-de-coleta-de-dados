package br.udesc.ceavi.custodevida.dao.core;

public class DatabaseDefinitions {

    public static final String TABLE_NAME_ITEM = "item";
    public static final String TABLE_NAME_SOURCE = "source";
    public static final String TABLE_NAME_RESEARCHER = "researcher";
    public static final String TABLE_NAME_SOURCE_RESOURCE = "source_resource";
    public static final String TABLE_NAME_CONTROL = "control";
    public static final String TABLE_NAME_SEARCH = "search";

    public static final String[] COLUMNS_NAMES_ITEM = new String[]
            {"_id","description","identifier"};
    public static final String[] COLUMNS_NAMES_SOURCE = new String[]
            {"_id","description","localization"};
    public static final String[] COLUMNS_NAMES_RESEARCHER = new String[]
            {"_id","name","user","password"};
    public static final String[] COLUMNS_NAMES_SOURCE_RESEARCHER = new String[]
            {"source_id","researcher_id"};
    public static final String[] COLUMNS_NAMES_CONTROL = new String[]
            {"_id","emission_date","delivery_date","percentage","source_id","researcher_id"};
    public static final String[] COLUMNS_NAMES_SEARCH = new String[]
            {"_id","old_date","old_brand","old_specification","old_price","new_date","new_brand",
                    "new_specification","new_price","item_id","control_id"};
}
