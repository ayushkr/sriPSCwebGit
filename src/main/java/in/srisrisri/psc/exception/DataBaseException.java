package in.srisrisri.clinic.exception;

public class DataBaseException extends Exception
{
    private static final long serialVersionUID = 1L;

    public DataBaseException()
    {
        super();
    }

    public DataBaseException(final String message)
    {
        super(message);
    }

    public DataBaseException(final Throwable databaseExceptionThrowable)
    {
        super(databaseExceptionThrowable);
    }

    public DataBaseException(final String message, final Throwable throwable)
    {
        super(message, throwable);
    }
}
