package org.easymis.vkwit.teacher.domain.service;

import java.util.Optional;

import org.easymis.vkwit.teacher.domain.config.CacheComponent;
import org.easymis.vkwit.teacher.domain.entity.EasyMisMember;
import org.easymis.vkwit.teacher.domain.repository.UserRepository;
import org.easymis.vkwit.teacher.domain.util.CommonUtils;
import org.easymis.vkwit.teacher.domain.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CacheComponent cacheComponent;
    public  EasyMisMember findOne(String id){
    	EasyMisMember user = null;
        //使用缓存
        Object object = cacheComponent.get(Constant.MERCHANT_CENTER_USER_ID, id.toString());
        if (CommonUtils.isNull(object)) {
        	Optional<EasyMisMember> member = userRepository.findById(id);
            if (member.isPresent()) {
            	user=member.get();
                cacheComponent.put(Constant.MERCHANT_CENTER_USER_ID, id.toString(), user, 12);            	
            }

        } else {
            user = (EasyMisMember) object;
        }
        return  user;
    }
}
