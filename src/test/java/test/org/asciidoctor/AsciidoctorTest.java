/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package test.org.asciidoctor;

import java.util.Collections;

import org.asciidoctor.Asciidoctor;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.undertow.WARArchive;

/**
 *
 * @author <a href="mailto:ggastald@redhat.com">George Gastaldi</a>
 */
@RunWith(Arquillian.class)
public class AsciidoctorTest {

    @Deployment(testable = false)
    public static WARArchive createDeployment() {
        WARArchive deployment = ShrinkWrap.create(WARArchive.class);
        deployment.add(EmptyAsset.INSTANCE, "nothing");
        return deployment;
    }

    @Test
    public void testCanCreateAsciidoctor() {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        Assert.assertNotNull(asciidoctor);
    }

    @Test
    public void testAsciidoctorRender() {
        Asciidoctor asciidoctor = Asciidoctor.Factory.create();
        String content = asciidoctor.render("Hello World", Collections.<String, Object> emptyMap());
        Assert.assertEquals("<div class=\"paragraph\">\n<p>Hello World</p>\n</div>", content);
    }
}
