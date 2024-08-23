package com.tuankhoi.backend.dto.document;

import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document(indexName = "sub_category")
public class SubCategoryDocument {
    @Id
    String id;

    @Field(type = FieldType.Keyword)
    String title;

    @Field(type = FieldType.Keyword)
    String description;

    @Field(type = FieldType.Keyword)
    String imageUrl;

    @Field(type = FieldType.Keyword)
    String cloudinaryImageId;

    @Field(type = FieldType.Keyword)
    String categoryId;

    @Field(type = FieldType.Keyword)
    String createdBy;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    LocalDateTime createdDate;

    @Field(type = FieldType.Keyword)
    String lastModifiedBy;

    @Field(type = FieldType.Date, format = DateFormat.date_hour_minute_second_millis)
    LocalDateTime lastModifiedDate;
}
