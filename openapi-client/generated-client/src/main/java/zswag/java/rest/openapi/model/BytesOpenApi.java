package zswag.java.rest.openapi.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * BytesOpenApi
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-01-20T14:32:47.992207+01:00[Europe/Berlin]")


public class BytesOpenApi   {
  @JsonProperty("values")
  @Valid
  private List<Integer> values = null;

  public BytesOpenApi values(List<Integer> values) {
    this.values = values;
    return this;
  }

  public BytesOpenApi addValuesItem(Integer valuesItem) {
    if (this.values == null) {
      this.values = new ArrayList<Integer>();
    }
    this.values.add(valuesItem);
    return this;
  }

  /**
   * Get values
   * @return values
   **/
  @ApiModelProperty(value = "")
  
    public List<Integer> getValues() {
    return values;
  }

  public void setValues(List<Integer> values) {
    this.values = values;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BytesOpenApi bytes = (BytesOpenApi) o;
    return Objects.equals(this.values, bytes.values);
  }

  @Override
  public int hashCode() {
    return Objects.hash(values);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BytesOpenApi {\n");
    
    sb.append("    values: ").append(toIndentedString(values)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
