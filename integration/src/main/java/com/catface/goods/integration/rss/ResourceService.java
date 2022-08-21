package com.catface.goods.integration.rss;

import com.catface.rss.api.resource.ResourceApi;
import org.springframework.stereotype.Service;

/**
 * @author catface
 * @since 2022/8/21
 */
@Service
public class ResourceService {

    private final ResourceApi resourceApi;

    public ResourceService(ResourceApi resourceApi) {
        this.resourceApi = resourceApi;
    }
}
