package ins.marianao.sailing.fxml.services;
import cat.institutmarianao.sailing.ws.model.User;

public class ServiceSaveUser extends ServiceSaveBase<User>{
	
	private static final String PATH_ADD_USER = "add/by/username";
	
	public ServiceSaveUser(User entity, Class<User> entityType, String[] path, Method method, boolean auth)
			throws Exception {
		super(entity, entityType, new String[] {
				ServiceQueryUsers.PATH_REST_USERS,PATH_ADD_USER,entity.getUsername()
		}, method, auth);
		
	}

}
