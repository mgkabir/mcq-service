package org.matrix.configs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 
 * Need to be removed.
 *
 */
@Controller
public class RootController {

  @RequestMapping("/")
  @ResponseBody
  public String index() {
    return "Can be removed ? ";
  }

}
