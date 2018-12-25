package org.mail.DAO;

import java.util.List;

import org.mail.vo.Draft;
import org.mail.vo.User;

public interface IDraftDAO {
	public void saveDraft(Draft d);
	public void deleteDraft(Draft d);
    public Draft getSingleDraft(Draft d);
    public List<Draft> getAllDraft(User u);
}
