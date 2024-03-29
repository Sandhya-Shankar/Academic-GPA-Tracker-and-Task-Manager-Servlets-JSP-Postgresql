import java.time.LocalDate;
public class Task {
	    private Long id;
	    private String title;
	    private String description;
	    private String targetDate;
	    private boolean status;

	    protected Task() {

	    }

	    public Task(long id, String title,String description, String targetDate, boolean isDone) {
	        super();
	        this.id = id;
	        this.title = title;
	        this.description = description;
	        this.targetDate = targetDate;
	        this.status = isDone;
	    }

	    public Task(String title,String description, String targetDate, boolean isDone) {
	        super();
	        this.title = title;
	        
	        this.description = description;
	        this.targetDate = targetDate;
	        this.status = isDone;
	    }

	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public String getTargetDate() {
	        return targetDate;
	    }

	    public void setTargetDate(String targetDate) {
	        this.targetDate = targetDate;
	    }

	    public boolean getStatus() {
	        return status;
	    }

	    public void setStatus(boolean status) {
	        this.status = status;
	    }

	    @Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result + (int)(id ^ (id >>> 32));
	        return result;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        Task other = (Task) obj;
	        if (id != other.id)
	            return false;
	        return true;
	    }
}
