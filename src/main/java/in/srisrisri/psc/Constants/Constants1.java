package in.srisrisri.psc.Constants;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public interface Constants1 {

    interface SortOrder {
        String ASCENDING = "ASC";
        String DESCENDING = "DESC";

    }

    String SPACE = " ";

    String MOBILE_LINE_SEPARATOR = "\n";

    String LESS_THAN = "<";

    String HYPHEN = "-";

    String LOCALHOST = "localhost";

    String GREATE_THAN = ">";

    String FORWARD_SLASH = "/";

    String PERCENT = "%";

    String UNDER_SCORE = "_";

    String DOLLAR = "$";

    String BLANK = "";

    int NO_OF_DAYS_FOR_PAUSE = 30;

    String DNT_REMOVE_SUCCESS = "Successfully removed @phoneNumber@ from Do Not Text List.";

    String PAUSE_REMOVE_SUCCESS = "Successfully removed temporary Do Not Text for number @phoneNumber@.";


    String SUCCESSFULL_WRONG_NUMBER = "Successfully marked wrong number: ";

    String FAILURE_WRONG_NUMBER = "Failed to mark wrong number for customer @customerName@ (@phoneNumber) due to an internal error. Please try again later.";

    String INVALID_WRONG_NUMBER_COMMAND = "Invalid command. Type 'C Wrong' OR 'C Wrong <10 digit phone number>' eg: C Wrong 9876543210";

    String PRODUCT_NAME = "productName";

    // Allows store & return count or just return count in price quote request
    String PRICE_POINT_FORMAT_VALIDATE = "^(\\d+\\s\\d+$)|^(\\d+$)";

    Pattern PATTERN_FOR_PRICE_POINT = Pattern.compile(PRICE_POINT_FORMAT_VALIDATE, Pattern.CASE_INSENSITIVE);

    String PRICE_TEMPLATE_POINT_OFF_SEASON = "Textellent:\nOffice(s): :stores\nReturns: :returns\nJan-Apr fee: $:taxSeason/mo\nMay-Dec fee: $:offSeason/mo\nActivation: $:activation One Time";

    String PRICE_POINT_TAX_SEASON = "";

    String APPEND_ZERO_IN_SINGLE_DATE = "0";

    String TAX_SCHOOL_YEAR_INQUIRIES_ORDER_BY = " ORDER BY tax_inquiries_id desc limit 5";

    String TAX_SCHOOL_STUDENT_ROSTER_ORDER_BY = " ORDER BY tax_school_student_id desc limit 5";

    int TY_MANDATORY_COLUMN_LENGTH = 5;

    int TAX_SCHOOL_STUDENT_ROSTER_MANDATORY_COLUMN_LENGTH = 4;

    int TAX_SCHOOL_INQUIRIES_MANDATORY_COLUMN_LENGTH = 5;

    int CONTACT_LIST_MANDATORYLENGTH = 1;

    int ACTIVATE_CAMAPIGN = 1;

    int DEACTIVATE_CAMPAIGN = 0;

    int DEFAULT_CLIENT_ID = 0;

    int DEFAULT_PRODUCT_ID = 0;

    String APPEND_ZERO_CLIENTSSN = "0";

    String FIRST_NAME_PLACEHOLDER = "<FIRST_NAME>";

    String LAST_NAME_PLACEHOLDER = "<LAST_NAME>";

    String OFFICE_ID_PLACEHOLDER = "<OFFICE_ID>";

    String MANAGER_NAME_PLACEHOLDER = "<MANAGER_FIRST_NAME>";

    String MANAGER_LAST_NAME_PLACEHOLDER = "<MANAGER_LAST_NAME>";

    String COMPANY_NAME_PLACEHOLDER = "<COMPANY_NAME>";

    String STORE_NAME_PLACEHOLDER = "<STORE_NAME>";

    String PHONE_PLACEHOLDER = "<PHONE>";

    String NAME = "<NAME>";

    String CLIENT_CODE = "<CLIENT_CODE>";

    String TAX_SCHOOL_INQUIRY_FIRST_NAME = "<INQUIRY_FIRST_NAME>";

    String TAX_SCHOOL_STUDENT_FIRST_NAME_PLACEHOLDER = "<STUDENT_FIRST_NAME>";

    String TAX_SCHOOL_STUDENT_LAST_NAME_PLACEHOLDER = "<STUDENT_LAST_NAME>";

    String TAX_SCHOOL_STUDENT_REFERRAL_EXPIRATION_DATE_PLACEHOLDER = "<STUDENT_REFERRAL_EXP_DATE>";

    String TAX_SCHOOL_STUDENT_REFERRAL_PAYOUT = "<STUDENT_REFERRAL_PAYOUT> ";

    String TAX_SCHOOL_INQUIRY_LAST_NAME = "<INQUIRY_LAST_NAME>";

    String CIF_PAY_OUT_PLACEHOLDER = "<CIF_PAYOUT>";

    String CIF_EXPIRATION_DATE_PLACEHOLDER = "<CIF_EXPIRATION_DATE>";

    String SAF_PAYOUT_TEMPLATE = "<SAF_PAYOUT>";

    String SAF_EXPIRATION_DATE_TEMPLATE = "<SAF_EXPIRATION_DATE>";

    String CLIENT_CODE_TEMPLATE = "<CLIENT_CODE>";

    String INSURANCE_ISSUING_COMPANY_PLACEHOLDER = "<ISSUING_COMPANY>";

    String INSURANCE_POLICY_TYPE_PLACEHOLDER = "<POLICY_TYPE>";

    String INSURANCE_ISSUE_DATE_PLACEHOLDER = "<ISSUE_DATE>";

    String INSURANCE_RENEWAL_DATE_PLACEHOLDER = "<RENEWAL_DATE>";

    String INSURANCE_PREMIUM_DUE_PLACEHOLDER = "<PREMIUM_DUE>";

    String INSURANCE_POLICY_TERM_PLACEHOLDER = "<POLICY_TERM>";

    String MONTHLY_PAYMENT_REMINDER_POLICY_NUMBER_PLACEHOLDER = "<POLICY_NUMBER>";

    String MONTHLY_PAYMENT_REMINDER_START_DATE_PLACEHOLDER = "<START_DATE>";

    String MONTHLY_PAYMENT_REMINDER_END_DATE_PLACEHOLDER = "<END_DATE>";

    String MONTHLY_PAYMENT_REMINDER_DUE_DATE_PLACEHOLDER = "<DUE_DATE>";

    String DOT = ".";

    String OFFICE_ID = "OfficeID";

    String CLIENT_SSN = "ClientSSN";

    String lAST_NAME = "LastName1";

    String FIRST_NAME = "FirstName";

    String ADDRESS = "Address";

    String CITY = "City";

    String PROVINCE = "StateProvince";

    String ZIP_CODE = "ZipCode";

    String EMAIL_ID = "EmailAddress";

    String DOB = "DateOfBirth";

    String GFTC = "GrandfatheredClient";

    String CODE_DESCRIPTION = "CodeDescription";

    String ADD_DATE = "AddDate";

    String W_PHONE = "WorkPhone";

    String H_PHONE = "HomePhone";

    String PRE_DEFINED_FILE_TYPE = "Pre-defined List";

    String DO_NOT_TEXT_LIST = "Do not text list file";

    String CSV_FILE_EXT = "csv";

    String TXT_FILE_EXT = "txt";

    String DOT_CSV_EXT = ".csv";

    String DOT_FILE_EXT = ".txt";

    String INVALID_FROM_PHONE_NUMBER_MESSAGE = "Invalid source phone number: ";

    String INVALID_CUSTOMER_PHONE_NUMBER_MESSAGE = "Invalid or no phone number provided [@phoneNumber@]. Please provide a 10-digit phone number.";

    String INVALID_TO_PHONE_NUMBER_MESSAGE = "Invalid destination number: ";

    String INVALID_TO_PHONE_NUMBER_MESSAGE_WITH_COUNTRY_CODE = "Invalid 'toNumber'. Expected format: <country code> <10 digit phone no>. Example: 14081234567. Received:";

    String INVALID_AUTH_CODE = "Invalid Authentication code.";

    String INVALID_MESSAGE = "Invalid message to send.";

    String INVALID_FROM_TIME = "Invalid 'fromtime'. Expected format: hh:mm am/pm. Example: 12:24 am. Received:";

    String INVALID_TO_TIME = "Invalid 'totime'. Expected format: hh:mm am/pm. Example: 12:24 am. Received:";

    String GREETING_TEMPLATE_ERROR_MESSAGE = "Invalid 'greetingtemplate'. Not recieved a proper text. Minimum length 10.";

    String PY_CIF_TEXT_ERROR_MESSAGE = "Parameter ':cifText' is not valid. Not recieved a proper text. Minimum length 30.";

    String PY_REMINDER_LEAD_DAYS_ERROR_MESSAGE = "Parameter ':leadNumberDays' is not valid. Recieved:";

    String PY_DATE_MESSGAGE_FORMAT = "Parameter ':date' is not valid. Expected format: mm/dd/yyyy. Example: 9/9/2013. Received:";

    String SAF_CIF_TEXT_ERROR_MESSAGE = "Parameter ':cifText' is not valid. Not recieved a proper text. Minimum length 30.";

    String SAF_REMINDER_LEAD_DAYS_ERROR_MESSAGE = "Parameter ':lagDays' is not valid. Recieved:";

    String SAF_DATE_MESSGAGE_FORMAT = "Parameter ':date' is not valid. Expected format: mm/dd/yyyy. Example: 9/9/2013. Received:";

    String ONHOLD_CIF_TEXT_ERROR_MESSAGE = "Parameter ':cifText' is not valid. Not recieved a proper text. Minimum length 30.";

    String ONHOLD_REMINDER_LEAD_DAYS_ERROR_MESSAGE = "Parameter ':lagDays' is not valid. Recieved:";

    String ONHOLD_DATE_MESSGAGE_FORMAT = "Parameter ':date' is not valid. Expected format: mm/dd/yyyy. Example: 9/9/2013. Received:";

    String NRC_CIF_TEXT_ERROR_MESSAGE = "Parameter ':cifText' is not valid. Not recieved a proper text. Minimum length 30.";

    String NRC_REMINDER_LEAD_DAYS_ERROR_MESSAGE = "Parameter ':lagDays' is not valid. Recieved:";

    String NRC_DATE_MESSGAGE_FORMAT = "Parameter ':date' is not valid. Expected format: mm/dd/yyyy. Example: 9/9/2013. Received:";

    String TAX_SCHOOL_FOLLOWUP_TEXT_ERROR_MESSAGE = "Parameter ':cifText' is not valid. Not recieved a proper text. Minimum length 30.";

    String TAX_SCHOOL_FOLLOWUP__LEAD_DAYS_ERROR_MESSAGE = "Parameter ':lagDays' is not valid. Recieved:";

    String TAX_SCHOOL_FOLLOWUP_DATE_MESSGAGE_FORMAT = "Parameter ':date' is not valid. Expected format: mm/dd/yyyy. Example: 9/9/2013. Received:";

    String TAX_SCHOOL_REFERRAL_TEXT_ERROR_MESSAGE = "Parameter ':cifText' is not valid. Not recieved a proper text. Minimum length 30.";

    String TAX_SCHOOL_REFERRAL__LEAD_DAYS_ERROR_MESSAGE = "Parameter ':lagDays' is not valid. Received:";

    String TAX_SCHOOL_REFERRAL_DATE_MESSGAGE_FORMAT = "Parameter ':date' is not valid. Expected format: mm/dd/yyyy. Example: 9/9/2013. Received:";

    String MISSING_PARAMETER = " parameter is missing.";

    String SPECIAL_CHARS_IN_PHONE_NUMBER = "[\\+\\(\\)\\-\\s\\.,/']";

    String PATTER_CHECK_ONLY_INTEGER = "^\\d+$";

    String REGEX_FOR_MESSAGE_BODY = "[^\\d|^\\W](.*)";
    Pattern PATTERN_FOR_MESSAGE_BODY = Pattern.compile(REGEX_FOR_MESSAGE_BODY);

    String REGEX_FOR_DNT = "^C\\sSTOP";
    Pattern PATTERN_FOR_DNT = Pattern.compile(REGEX_FOR_DNT, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_PAUSE = "^C\\sPAUSE";
    Pattern PATTERN_FOR_PAUSE = Pattern.compile(REGEX_FOR_PAUSE, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_WRONG_NUMBER = "^C\\sWRONG";
    Pattern PATTERN_FOR_WRONG_NUMBER = Pattern.compile(REGEX_FOR_WRONG_NUMBER, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_UNDO = "^C\\sUNDO";
    Pattern PATTERN_FOR_UNDO = Pattern.compile(REGEX_FOR_UNDO, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_C_LISTS = "^C\\sLISTS$";
    Pattern PATTERN_FOR_C_LISTS = Pattern.compile(REGEX_FOR_C_LISTS, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_C_BLAST_FOR_CREATE_BLAST = "^C\\sBLAST\\s[A-Za-z0-9]+\\s[A-Za-z0-9]+";
    Pattern PATTERN_FOR_CREATE_BLAST = Pattern.compile(REGEX_FOR_C_BLAST_FOR_CREATE_BLAST, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_C_TRIGGER_BLAST = "^C\\sTRIGGER\\s[0-9]$";
    Pattern PATTERN_FOR_C_TRIGGER_BLAST = Pattern.compile(REGEX_FOR_C_TRIGGER_BLAST, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_C_FIND = "^C\\sFIND\\s[A-Za-z0-9-]{2,20}$";
    Pattern PATTERN_FOR_C_FIND = Pattern.compile(REGEX_FOR_C_FIND, Pattern.CASE_INSENSITIVE);

    String REGEX_FOR_C_JOIN_LIST_NAME = "^JOIN\\s[A-Za-z0-9]+";
    Pattern PATTERN_FOR_C_JOIN_LIST_NAME = Pattern.compile(REGEX_FOR_C_JOIN_LIST_NAME, Pattern.CASE_INSENSITIVE);

    String REGEX_US_PHONE_NUMBER = "(\\+1)?\\s?[-\\(]?[\\d]{3}[-\\)]?\\s?[\\d]{3}[-\\s]?[\\d]{4,}";
    Pattern PATTERN_US_PHONE_NUMBER = Pattern.compile(REGEX_US_PHONE_NUMBER);

    String HARCODED_FROM_TIME = "09:45:00";

    String HARCODED_TO_TIME = "10:45:00";

    String PY_HARCODED_FROM_TIME = "09:45:00";

    String PY_HARCODED_TO_TIME = "10:45:00";

    String HARCODED_GREETING_TEXT = "Hi <FIRST_NAME>, Happy Birthday! From <MANAGER_FIRST_NAME> at Liberty Tax Service :-)";

    int START_ROW_FOR_CSV_READ = 4;

    String FALSE = "false";

    String SUCCESS = "success";

    String FAILED = "failed";

    String CATEGORY_RECURRING_PAYMENT = "RECURRING_PAYMENT";

    String CODE_PAYMENT_SUCCESS = "PAYMENT_SUCCESS";

    String CODE_PAYMENT_FAILED = "PAYMENT_FAILURE";

    String CODE_PAYMENT_FAILED_LIMIT = "PAYMENT_FAILURE_LIMIT";

    String CODE_PAYMENT_FAILED_DEACTIVATE = "PAYMENT_FAILURE_DEACTIVATE";

    int ACTIVE = 1;

    String FAILURE = "failure";

    String EMPTY = "empty";

    String INVALID_SECURITY_CODE = "Incorrect security code provided.";

    String NO_MEDIA_FOUND = "No media found for file id: @fileId@";

    String TEXT_BLAST_NO_CAMPAIGN_FOUND = "No TextBlast Campaign Found!";

    String NO_TOKEN_ID_FOUND = "Invalid or not tokenId present.";

    String NO_SECURITY_CODE_FOUND = "Parameter \"securityCode\" missing.";

    String TRUE = "true";

    String GENERIC_TY_TABLE_NAME = "ty_:year_list_data";

    String CLIENT_CREATE_EVENT = "Create Client";

    String CLIENT_UPDATE_EVENT = "Update Client";

    String CLIENY_DELETE_EVENT = "Delete Client";

    String CREATE_OFFICE = "Create Office";

    String UPDATE_OFFICE = "Update Office";

    String DELETE_OFFICE = "Delete Office";

    String PREDEFINED_LIST_NAME = "Invalid File. Only .csv format of Pre-Defined List file is supported";

    String TAX_SCHOOL_STUDENT_ROSTER_INVALID_FILE_FORMAT = "Invalid File. Only .csv format of Tax School Students file is supported.";

    String TAX_SCHOOL_STUDENT_INQUIRIES_INVALID_FILE_FORMAT = "Invalid File. Only .csv format of Tax School Inquiries file is supported.";

    String TAX_SCHOOL_YEAR_STUDENT_ROSTER_COLUMNS_MISSING = "Textbox37, Textbox18, DayPhoneNumber, NightPhoneNumber are the required columns in the Tax School Students file.";

    String TAX_SCHOOL_YEAR_STUDENT_INQUIRIES_COLUMNS_MISSING = "InquiryOfficeID1, Textbox73, KitSentDate, Textbox1, Textbox2 are the required columns in the Tax School Inquiries file.";

    String TAX_SCHOOL_YEAR_SUDENT_INQUIRIES_UPLOADING_ERROR = "Error Occured while uploading the Tax School Inquiries file. Please try again later.";

    String TAX_SCHOOL_YEAR_SUDENT_ROSTER_UPLOADING_ERROR = "Error Occured while uploading the TAX SCHOOL STUDENT file. Please try again later.";

    String TEXT_BLAST_CSV_COLUMN_MISSING = "\"Phone\" is the required first column in the uploaded file.";

    String TEXT_BLAST_LIST_COLUMN_DUPLICATE = "List Name already exists. Please try a different name!";

    String PREDEFINED_FILE_UPLOADING_ERROR = "Error Occured while uploading the Pre-Defined client file. Please try again later.";

    String SESSION_EXPIRED_MESSAGE = "Invalid tokenId or session expired. Please login again";

    String INTERNAL_SERVER_ERROR = "Sorry, there was a problem in completing your request. Please try again later.";

    String UNAUTHORIZED_TO_EDIT_OFFICE = "User is unauthorized to update office settings.";

    String INVALID_DATA_FORMAT_FOUND = "Invalid data format found. Expected input data format is JSON.";

    String INVALID_OFFICE_SETTING_ID = "Invalid \"officeSettingId\" parameter found.";

    String INVALID_MANAGER_FORWARD_OPTION = "Invalid \"messageForwardingOption\" parameter found. Expected are FWDALL ,DNTFWD ,FWDWNL ";

    String INVALID_TIME_ZONE = "'timeZone' is missing or not supported.";

    String MEDIA_FILE_UPLOAD_FAILURE_MESSAGE = "Fails to upload the file!";

    String C_SUCCESS_CREATE_BLAST = "TextBlast :blastId created.";

    String C_FAILS_CREATE_BLAST = "Fails to create the Text Blast.";

    String DASHBOARD_OFFICE_LIST_ERROR_MESSAGE = "There was an error completing your request. Please try again later.";

    String DASHOBOARD_ERROR_MESSAGE_FROM_DATE = "Missing or invalid 'From' date. Please provide date in mm/dd/yyyy.";

    String DASHOBOARD_ERROR_MESSAE_TO_DATE = "Missing or invalid 'To' date. Please provide date in mm/dd/yyyy.";

    String DASHOBOARD_ERROR_MESSGAE_OFFICE_ID = "Invalid 'officeId'. Expected format: 5100010 Or all. Received:";

    String DASHBOARD_OFFICE_ID_ERROR = "Invalid officeId. OfficeId value can either be 'All' or a valid integer.";

    String ALL = "all";

    String DATE_DETAIL = "date_detail";

    String SYSTEM_USER_NAME = "SYSTEM";

    String MENU_USER = "Users";

    String MENU_OFFICE = "Offices";

    String USERNAME_ALREADY_EXIST = "This username is already taken.";

    String CREATE_USER_SAVE_ERROR = "An error occured while creating user. Try again later.";

    String PERMISSION_DENIED = "Permission denied.";

    String PARAMETER = "Parameter";

    String MISSING = "missing.";

    String NOT_VALID_EMAIL_ADDRESS = "";

    String NO_USER_ID_FOUND = "No user found for userId";

    String NO_OFFICE_RECORD = "No office found for officeId";

    String COMMA = ",";

    String COLAN = ":";

    String INVALID_OFFICE_ID = "officeId is missing or not a valid number.";

    String TWELVE_HOUR_FORMAT = "hh:mm a";

    String PY_START_TIME = "10:33";

    String PY_END_TIME = "17:42";

    String PY_CIF_AMOUNT = "50";

    String PY_EXPIRATION_DATE = "2/15/2014";

    int PY_NUMBER_1_LEAD_DAYS = 15;

    int PY_NUMBER_2_LEAD_DAYS = 7;

    int PY_NUMBER_3_LEAD_DAYS = 2;

    String PY_REMINDER_1_CIF_TEXT = "Hi <FIRST_NAME>, It's Tax Time. Get <CIF_PAYOUT> cash and get your taxes done! Exp: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> at Liberty Tax :-)";

    String PY_REMINDER_2_CIF_TEXT = "Hi <FIRST_NAME>, Reminder: Let us take care of your taxes and walk out with <CIF_PAYOUT> cash! Exp: <CIF_EXPIRATION_DATE> :-) Liberty Tax.";

    String PY_REMINDER_3_CIF_TEXT = "Hi <FIRST_NAME>, Get <CIF_PAYOUT> cash and let us take care of your taxes. Exp: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> at Liberty Tax :-)";

    String PY_REMINDER_1_NON_CIF_TEXT = "Hi <FIRST_NAME>, It's Tax Time. Come in to Liberty Tax and get your taxes done. <MANAGER_FIRST_NAME> at Liberty Tax :-)";

    String PY_REMINDER_2_NON_CIF_TEXT = "Hi <FIRST_NAME>, Reminder: Let us take care of your taxes. Call us or come in. <MANAGER_FIRST_NAME> at Liberty Tax :-)";

    String PY_REMINDER_3_NON_CIF_TEXT = "Hi <FIRST_NAME>, We want to take care of your taxes for you as soon as you are ready! <MANAGER_FIRST_NAME> at Liberty Tax :-)";

    String PY_COLUMNS_NAME = "client_id, full_name, prep_status, date_created, preparer_id, office, phone_number, alt_phone, sp_full_name, sp_mobile, sp_phone, sp_alt_phone";

    String PHONE_HASH = "phone_hash";

    String WORK_HASH = "work_hash";

    String TY_CLIENT_DATA_COLUMNS = "client_id, full_name, prep_status, date_created, preparer_id, office, phone_number, invoice_number, date_modified, alt_phone, sp_full_name, sp_mobile, sp_phone, sp_alt_phone";

    String TAX_SCHOOL_PREVIEW_COLUMN_NAMES = "*";

    String STATUS_COMPLETE = "Complete";

    String STATUS_ONHOLD = "On Hold";

    String STATUS_YES = "YES";

    String STATUS_NO = "NO";

    Integer YES = 1;

    Integer NO = 0;

    String COMMON_ORDER_BY = " ORDER BY phone_number";

    String PY_COLUMNS_NAMES_FOR_2010 = "client_id,full_name,prep_status,date_created,prepare_r_id,office,work_hash";

    String PY_ORDER_BY = " ORDER BY phone_number, DATE_FORMAT(STR_TO_DATE(`date_created`, '%m/%d/%Y %H:%i:%s'), '%m/%d/%Y') desc";

    String NRC_ORDER_BY = " ORDER BY phone_number, DATE_FORMAT(STR_TO_DATE(`date_created`, '%m/%d/%Y %H:%i:%s'), '%m/%d/%Y') desc";

    String PY_ORDER_BY_2010 = " ORDER BY work_hash, DATE_FORMAT(STR_TO_DATE(`date_created`, '%m/%d/%Y %H:%i:%s'), '%m/%d/%Y') desc";

    int PY_REMINDER_1_TYPE = 1;

    int PY_REMINDER_2_TYPE = 2;

    int PY_REMINDER_3_TYPE = 3;

    String SAF_REMINDER_1_TEXT = "Hi <FIRST_NAME>, Make up to <SAF_PAYOUT> cash now for each client you send. Text your personal code to your friends: <CLIENT_CODE>. They will get <CIF_PAYOUT> too! Expires <CIF_EXPIRATION_DATE>.";

    String SAF_REMINDER_1_NON_CIF_TEST = "Hi <FIRST_NAME>, Get up to <SAF_PAYOUT> cash now for each client you refer. Text your personal code to your friends: <CLIENT_CODE>. Expires <SAF_EXPIRATION_DATE>.";

    String SAF_REMINDER_2_TEXT = "Hi <FIRST_NAME>, Make up to <SAF_PAYOUT> cash now for each client you send. Text your personal code to your friends: <CLIENT_CODE>. They will get <CIF_PAYOUT> too! Expires <CIF_EXPIRATION_DATE>.";

    String SAF_REMINDER_2_NON_CIF_TEST = "Hi <FIRST_NAME>, Get up to <SAF_PAYOUT> cash now for each client you refer. Text your personal code to your friends: <CLIENT_CODE>. Expires <SAF_EXPIRATION_DATE>.";

    String SAF_REMINDER_3_TEXT = "Hi <FIRST_NAME>, Make up to <SAF_PAYOUT> cash now for each client you send. Text your personal code to your friends: <CLIENT_CODE>. They will get <CIF_PAYOUT> too! Expires <CIF_EXPIRATION_DATE>";

    String SAF_REMINDER_3_NON_CIF_TEST = "Hi <FIRST_NAME>, Get up to <SAF_PAYOUT> cash now for each client you refer. Text your personal code to your friends: <CLIENT_CODE>. Expires <SAF_EXPIRATION_DATE>.";

    int SAF_REMINDER_1_TYPE = 1;

    int SAF_REMINDER_2_TYPE = 2;

    int SAF_REMINDER_3_TYPE = 3;

    int REMINDER_1_TYPE = 1;

    int REMINDER_2_TYPE = 2;

    int REMINDER_3_TYPE = 3;

    String SAF_START_TIME = "10:10:00";

    String SAF_END_TIME = "15:33:00";

    String SAF_CIF_AMOUNT = "50";

    String SAF_CIF_EXPIRATION_DATE = "2/15/2014";

    String SAF_AMOUNT = "50";

    String SAF_EXPIRATION_DATE = "4/15/2014";

    int SAF_NUMBER_1_LAG_DAYS = 1;

    int SAF_NUMBER_2_LAG_DAYS = 3;

    int SAF_NUMBER_3_LAG_DAYS = 7;

    String ONHOLD_REMINDER_1_CIF_TEXT = "Hi <FIRST_NAME>, Friendly reminder. Come in and get your taxes done. Also get <CIF_PAYOUT> cash on the spot! Expires: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String ONHOLD_REMINDER_2_CIF_TEXT = "Hi <FIRST_NAME>, We worked on your taxes. Let us complete them now. Also get <CIF_PAYOUT> cash on the spot! Expires: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String ONHOLD_REMINDER_3_CIF_TEXT = "Hi <FIRST_NAME>, Final reminder. Let us finish your taxes. Also get <CIF_PAYOUT> cash on the spot! Expires: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String ONHOLD_REMINDER_1_NON_CIF_TEXT = "Hi <FIRST_NAME>, Friendly reminder. Come in and get your taxes done. Please come by or call. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String ONHOLD_REMINDER_2_NON_CIF_TEXT = "Hi <FIRST_NAME>, We worked on your taxes. Let us complete them now. Please come by or call to make an appointment. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String ONHOLD_REMINDER_3_NON_CIF_TEXT = "Hi <FIRST_NAME>, Final reminder. Let us finish your taxes. Please come by or call to make an appointment. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String NRC_OFFER_1_CIF_TEXT = "Hi <FIRST_NAME>, Please accept a special <NRC_DISCOUNT> off just for you. Also get <CIF_PAYOUT> cash! Expires: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String NRC_OFFER_2_CIF_TEXT = "Hi <FIRST_NAME>, Please accept a special <NRC_DISCOUNT> off just for you. Also get <CIF_PAYOUT> cash! Expires: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String NRC_OFFER_3_CIF_TEXT = "Hi <FIRST_NAME>, Final Reminder: Please accept a special <NRC_DISCOUNT> off just for you. Also get <CIF_PAYOUT> cash! Expires: <CIF_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String NRC_OFFER_1_NON_CIF_TEXT = "Hi <FIRST_NAME>, Please accept a special <NRC_DISCOUNT> off just for you. Expires: <NRC_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String NRC_OFFER_2_NON_CIF_TEXT = "Hi <FIRST_NAME>, Please accept a special <NRC_DISCOUNT> off just for you. Expires: <NRC_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String NRC_OFFER_3_NON_CIF_TEXT = "Hi <FIRST_NAME>, Final Reminder. Please accept a special <NRC_DISCOUNT> off just for you. Expires: <NRC_EXPIRATION_DATE>. <MANAGER_FIRST_NAME> from Liberty Tax :-)";

    String ONHOLD_START_TIME = "10:43:00";

    String ONHOLD_END_TIME = "17:15:00";

    String ONHOLD_CIF_AMOUNT = "50";

    String ONHOLD_CIF_EXPIRATION_DATE = "2/15/2014";

    int ONHOLD_REMINDER_1_LAG_DAYS = 2;

    int ONHOLD_REMINDER_2_LAG_DAYS = 7;

    int ONHOLD_REMINDER_3_LAG_DAYS = 14;

    String NRC_START_TIME = "09:58:00";

    String NRC_END_TIME = "16:03:00";

    String NRC_CIF_AMOUNT = "50";

    String NRC_CIF_EXPIRATION_DATE = "2/15/2014";

    int NRC_REMINDER_1_LAG_DAYS = 7;

    int NRC_REMINDER_2_LAG_DAYS = 14;

    int NRC_REMINDER_3_LAG_DAYS = 21;

    int NRC_DISCOUNT = 30;

    String NRC_EXPIRATION_DATE = "4/9/2014";

    String NRC_DISCOUNT_TEMPLATE = "<NRC_DISCOUNT>";

    String NRC_EXPIRATION_DATE_TEMPLATE = "<NRC_EXPIRATION_DATE>";

    String PAUSE_SUCCESS = "@phoneNumber@ paused till @expirationDate@";

    String INVALID_PAUSE_COMMAND = "Invalid command. Type 'C PAUSE <10-digit phone number>' to pause for 30 days OR 'C PAUSE 75 <10-digit phone number>' to pause for 75 days";

    String INVALID_UNDO_COMMAND = "Invalid command. Type 'C UNDO' to remove last added phone number or 'C UNDO <10-digit phone number>' to remove the phone number from Do Not Text or Wrong Number list.";

    Integer maxDaysLimitForPause = 365;

    String TEXT_BLAST_START_DATETIME_MISSING = "Parameter \"initialScheduledDateTime\" is missing.";

    String FAILURE_ADDING_NUMBER = "Failed to add number to contact list.";

    String FAILURE_DELETING_CONTACT_LIST = "Failed to delete contact list.";

    String NUMBER_ALREADY_EXIST_IN_LIST = "Phone number already exists in the list.";

    String TEXT_BLAST_FAILURE_TRIGGER = "Failed to trigger text blast.";

    String TEXT_BLAST_FAILURE_STOP = "Failed to stop text blast.";

    String TEXT_BLAST_RETRIEVE_TEXT_BLAST_LIST = "Failed to retrieve textblast list!";

    String TEXT_BLAST_ID_INVALID = "Missing or invalid text blast id.";

    String TEXT_BLAST_LIST_NAME_MISSING = "Parameter \"listShortName\" is missing.";

    String TEXT_BLAST_INVALID_LIST_NAME = "Invalid listShortName: ";

    String TEXT_BLAST_INVALID_LIST_NAME_MISSING = "Parameter \"listShortName\"  is missing.";

    String TEXT_BLAST_OFFICE_ID_MISSING = "Parameter \"officeId\"  is missing.";

    String TEXT_BLAST_FROM_OFFICE_ID_MISSING = "Parameter \"fromOfficeId\"  is missing.";

    String SEND_ONLY_FROM_ONE_POFFICE = "Parameter \"onlySendFromOneOffice\"  is invalid. Only true or false expected.";

    String TEXT_BLAST_OFFICE_ID_INVALID = "Parameter \"officeId\"  is invalid. Client does not belongs to this officeId.";

    String TEXT_BLAST_ACTIVE = "Text blast only in \"Pending\" or \"Draft\" status can be edited. This text blast is in \"@status@\" status.";

    String INVALID_LIST_SHORT_NAME = "Parameter \"listShortName\" is invalid. We have not found any record !";

    String TEXT_BLAST_PHONE_NUMBER_MISSING = "Parameter \"phoneNumber\"  is not valid. Format: 6789098765";

    String TEXT_BLAST_INVALID_START_DATETIME = "Invalid value for \"initialScheduledTime\". Format is: 2014-03-04 10:45:11";

    String TEXT_BLAST_SHORT_DESC_LIST_MISSING = "Parameter \"shortDesc\" is missing.";

    String TEXT_BLAST_FILE_LIST_NAME_MISSING = "Parameter \"name\" is missing.";

    String TEXT_BLAST_IS_NOT_DRAFT = "Failure: This text blast is not a \"Draft\", so it cannot be saved as \"Draft\", Use \"Schedule\" button to save changes";

    String WRONG_VALUE_ASSOCIATED_OFFICE = "Invalid value for associated office!";

    String TEXT_BLAST_FAILS = "Unable to retrive the list. Please try again later.";

    String FAILS_RESET_CAMPAIGN_INFO = "Failed to reset campaign detail.";

    int MAX_LINE_COUNT = 10;

    String ACCOUNT_LOCKED = "Account locked. Please contact Support.";

    String MEDIA_FILES_GET_LIST_ERROR = "Failed to get media files list";

    String MEDIA_FILES_INVALID_FILE_ID = "Invalid file id!";

    String MEDIA_URL = "MediaUrl";

    String MEDIA_NUM_FOUND = "NumMedia";

    int LibTextProductId = 801;

    int ProtextProductId = 804;

    String SIGNUP_SUCCESS = "Signup via SMS successful. <FIRST_NAME> (<PHONE_NUMBER>) added to <LIST_SHORT_NAME>";

    String USER_DEFINED_SUCCESS_MESSAGE = "Signup via SMS successful. <PHONE_NUMBER> added to <LIST_SHORT_NAME>";

    String FAILS_AVAILABLE_FUND_MESSAGE = "Fails to get the available funds. Please try again later.";

    String PRO_TEXT_PREP_STATUS_MAPPING_ERROR = "Failed to get pro text prep status mapping";

    String FILE_WRITE_ERROR = "An error occured while saving uploaded file to disk. Please contact system administrator.";

    String MANDATORY_COLUMNS_MISSING = " are the mandatory columns.";

    String UNSUPPORTED_DATA_FILE = "Provided data file type [@dataFileType@] is not supported.";

    String UPLOAD_DATA_FILE_EXT_ERROR = "Unsupported file extension [@extension@].";

    String SB_DATA_FILE_UPLOAD_ERROR = "Error uploading the file(s) to the folder.";

    String SB_DATA_FILE_UPLOAD_SUCCESS = "Successfully uploaded the file(s)";

    String NO_FILE_TYPE_FOUND = "No data file type found.";

    String NOT_FOUND_VALID_EXTENSION = "Invalid File Type/Extension.";

    String FIND_MESSAGE_FORMAT = "<COMPANY_NAME>: Client code: <CLIENT_CODE>\nName: <NAME>\nPhone:<PHONE_NUMBER>";

    String PHONE_NUMBER_PLACEHOLDER = "<PHONE_NUMBER>";

    String MISSING_MANDATORY_COLUMNS = "One or more mandatory columns are missing. Please provide data for these columns ";

    String INCORRECT_YEAR_FILE = "It appears an incorrect tax year file is being uploaded. You have selected to upload <File year chosen> tax year file.";

    String SIGNUP_FAILURE = "Failed to signup due to an internal error.\n [@phoneNumber@] @originalText@";

    String FILE_YEAR_CHOOSEN = "<File year chosen>";

    String LINE_SEPERATOR = System.getProperty("line.separator");

    String FAILURE_UPDATE_MESSAGE = "Failure in updating office settings. Kindly validate the data.";

    String CONVERSATION_HISTORY_INVALID_OFFICE_ID = "Invalid officeId parameter. Expected format: 501001 or 501001,502002 ";

    String CONVERSATION_HISTORY_INVALID_FILTER_SETTING_ID = "Invalid dialogFilterSettingId parameter: ";

    String INVALID_CAMPAIGNS_STRING = "One of more invalid campaigns specified : ";

    String INVALID_DATE_FORMAT = "Invalid dateParameter parameter. Expected format: YYYY-MM-DD. Recieved :";

    String CONVERSATION_HISTORY_INVALID_TIME_RANGE = "To date can either be equal to or later than From date.";

    String INVALID_MESSAGE_ID = "Invalid or no messageId found.";

    String INVALID_CONVERSATION_DIRECTION = "Invalid \"conversationDirection\" parameter found.";

    String INVALID_CURRENT_MESSAGE_DIRECTION = "Invalid \"currentMessageDirection\" parameter vfound.";

    String NO_MESSAGE_BODY_FOUND = "messageBody is missing.";

    String INVALID_MANAGER_NUMBER = "managerNumber is missing or not a valid phone number.";

    String MISSING_CUSTOMER_NUMBER = "customerNumber is missing or not a valid phone number.";

    String BROWSER = "Browser";

    String CUSTOMER_NUMBER_PLACEHOLDER = ":customerNumber";

    String TWILIO_UNKNOWN_STATUS = "Service provider returned an unknown status. Message may not have been sent.";

    String GET_CONVERSATION_HISTORY_MESSAGE = "No more conversations.";

    String UNREAD = "Unread";

    String ERROR = "Error";

    String INVALID_MESSAGE_DIRECTION = "Invalid messageDirection value : ";

    String INVALID_DELIVERY_STATUS = "One or more invalid deliveryStatus specified : ";

    String INVALID_OFFICE_STRING = "One or more invalid offices specified : ";

    String BLACKLISTED_NUMBER = "Failed sending message. Phone number is blacklisted and has been added to Do Not Text List: ";

    String NUMBER_IN_DNT = "Phone number in Do Not Text List. Cannot send.";

    String TWILIO_ERROR = "Failed sending message. There was an unknown error sending message.";

    String UNABLE_TO_MARK_WRONG_NUMBER = "Unable to mark wrong number. Could not find customer details for phone number ";

    String NO_CUSTOMER_NAME = "No customer name provided.";

    String TOKEN_ID = "tokenId";

    String NOTHING_TO_UNDO = "Could not find anything to undo.";

    String MISSING_PARAMETERS = "One or more input parameters are missing.";

    String TY_YEAR = "ty_year";

    String HTML_FILE_EXT = ".html";

    String DEFAULT = "default";

    String FAILURE_HELP_FILE_MISSING = "The required help file could not be found.";

    String HELP_FILE_READ_FAILURE = "There was an error getting help content.";

    String SOFTWARE_NAME_MISSING = "Software name is missing for client in DB. Failed to get HTML help file.";

    String FILE_TYPE = "fileType";

    String LOGIN_ERROR = "Login Error. Please contact Support.";

    String WHISPER_TEXT = "whisper";

    String SOUND_NOTIFICATION = "sound_notification";

    String INCOMING_CALL_ID = "incoming_call_id";

    String ON = "on";

    String OFF = "off";

    String INVALID_PASSWORD = "Current password entered does not match. Please try again.";

    String INVALID_FIRST_NAME = "Please enter your first name.";

    String INVALID_LAST_NAME = "Please enter your last name.";

    String INVALID_PHONE_NUMBER = "Please enter a valid US phone number.";

    String INVALID_DEMO_TEMPLATE_ID = "templateId is missing or not a valid number.";

    String INVALID_CONTACT_LIST_NAME = "contactListName is missing or not valid.";

    String APPOINTMENT = "Appointment";

    String INSURANCE = "Insurance";

    String MONTHLYPAYMENTREMINDER = "MonthlyPaymentReminder";

    String MISSEDAPPOINTMENT = "MissedAppointmentReminder";

    String APPOINTMENTFOLLOWUP = "AppointmentFollowUp";

    String DRIP_CAMPAIGN = "DripCampaign";

    String APPOINTMENT_STATUSES = "appointment_statuses";

    int TEXTBLAST_FUND_MINIMUM_AMOUNT = 50;

    String AMOUNT_BELOW_MINIMUM = "Amount is below the required minimum";

    String MAKE_PAYMENT_ERROR = "Error while charging card in Auth.net service";

    String DAYS = "Days";

    String WEEKS = "Weeks";

    String MONTHS = "Months";

    String HOURS = "Hours";

    String APPOINTMENT_DATE_TIME_PLACEHOLDER = "<APPT_DATE_TIME>";

    String APPOINTMENT_LINK_PLACEHOLDER = "<APPT_LINK_____________________________>";

    String APPOINTMENT_BOOKING_PAGE_PLACEHOLDER = "<APPT_BOOKING_PAGE>";

    String PAYMENT_PROFILE_NOT_EXISTS = "Please add a payment profile under Management Options before attempting a payment.";

    String ADD_PAYMENT_DETAILS_TO_DB_ERROR = "Error in adding payment details to database";

    String TRANSACTION_NULL_ERROR = "Error updating transaction details in server.";

    String INVALID_AMOUNT_MESSAGE = "Please provide a valid amount.";

    String REQUIRE_OWNER_USER_MESSAGE = "The user should be an owner to call this api.";

    String ERROR_LOADING_CREDENTIAL_FILE = "Cannot load credentials from the credentials profile file";

    String VERIFICATION_MAIL_SENT = "Verification email successfully sent from Amazon SES";

    String VERIFICATION_MAIL_NOT_SENT = "Error in sending verification email from Amazon SES";

    String USER_DETAILS_READ_ERROR = "Error in reading user details from server";

    String INVALID_EMAIL_ID = "Please provide a valid email address";

    int TEXTELLENT_CLIENT_ID = 59;

    String MAX_TEXT_BLAST_CREDIT = "50";

    List<String> tollFreeNumbers = Arrays.asList("800", "877", "866", "855", "844", "833", "822", "880", "881", "882", "883", "884", "885", "886", "887", "888", "889");

    String NULL = "null";

    String PUERTO_RICO_AREA_CODE = "787";

    int TEXTBLAST_MESSAGE_TEMPLATE_LIMIT = 500;

    int COUNT_OF_NUMBERS_TO_MATCH = 6;

    BigDecimal FREE_TEXT_BLAST_CREDIT = new BigDecimal("5.90");

    int BILL_CYCLE_DAY = 1;

    String CURRENCY = "USD";

    String LIB_TEXT_PRODUCT_FROM_SAY = "Incoming phone call from @@FromName@@";

    String LIB_TEXT_PRODUCT_SAY = "Incoming phone call";

    String PRODUCT_FROM_SAY = "@@ProductName@@ forwarding incoming call from @@FromName@@";

    String PRODUCT_SAY = "@@ProductName@@ forwarding incoming call";

    String NO_ACCESS_TO_MEDIA_FILE = "Access Denied. It's a default file provided by the service.";

    String HEADER_MISSING = "Please specify headers for all columns.";

    String APPOINTMENT_BOOKING_BASE_URL = "short_base_url";

    String BASE = "BASE";

    String PAUSE = "PAUSE";

}
