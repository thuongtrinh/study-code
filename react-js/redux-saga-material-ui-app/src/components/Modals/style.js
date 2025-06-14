import styled from "styled-components";
import customTheme from "../../commons/Theme";

export const ModalDiv = styled("div")({
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  position: "absolute",
  width: 400,
  backgroundColor: customTheme.palette.background.paper,
  boxShadow: customTheme.shadows[5],
  // padding: theme.spacing(2, 4, 4),
  outline: "none",
});

export const HeaderDiv = styled("div")({
  backgroundColor: customTheme.color.primary,
  color: customTheme.color.textColor,
  padding: customTheme.spacing(2),
  display: "flex",
  alignItems: "center",
  justifyContent: "space-between",
});

export const TitleDiv = styled("div")({
  color: customTheme.color.textColor,
  fontWeight: 700,
  textTransform: "capitalize",
});


export const styleIcon = {
  cursor: "pointer",
  fontSize: 30,
};

export const ContentDiv = styled("div")({
  padding: customTheme.spacing(2),
});
